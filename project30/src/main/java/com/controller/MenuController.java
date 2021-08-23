package com.controller;

import com.pojo.MenuType;
import com.pojo.SysAction;
import com.pojo.SysMenu;
import com.service.ActionService;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;
    @Autowired
    ActionService actionService;

    /**
     * 进入主页home时获得顶部菜单的菜单树   |  需根据角色
     */
    @RequestMapping("/home/loadMenu")
    @ResponseBody
    public List<SysMenu> loadMenu(HttpServletRequest req){
        List<SysMenu> menuTree = menuService.getMenuTreeByRole(req);
        return menuTree;
    }

    /**
     * 菜单管理页面
     */
    @RequestMapping("/menu/menuManage_init")
    public String menuManage_init(){
        return "dev/menu_manage";
    }

    /**
     * 点击顶部菜单管理后需要的菜单树
     */
    @RequestMapping("/menu/menuManage_menuTree")
    @ResponseBody
    public List<SysMenu> menuManage_menuTree(){
        List<SysMenu> menuTree = menuService.getMenuTreeWithoutAction();
        return menuTree;
    }

    /**
     * 菜单管理页面内的菜单详情页面
     * 本方法将带着数据到jsp
     */
    @RequestMapping("/menu/menu_detail")
    @ResponseBody
    public HashMap<String, Object> menu_detail(Integer menuId, Integer type, Model model, HttpServletRequest req){
        //处理其它控制器方法访问本方法时无法直接传递"menuId"问题
        //因此时menuId已不是请求时的menuId，应设置一个标志做判断
        Boolean overrideMenuId = (Boolean)req.getAttribute("overrideMenuId");
        if(overrideMenuId!=null && overrideMenuId){
            menuId = Integer.parseInt(req.getAttribute("menuId")+"");
        }

        //本菜单对象
        SysMenu menu = menuService.findMenuById(menuId);

        //parent菜单对象
        SysMenu parentMenu = menuService.findMenuById(menu.getParentId());

        //子菜单列表
        List<SysMenu> subMenuList = menuService.findSubMenuList(menuId);

        //全部动作URL的列表
        List<String> ListUrl = actionService.findAllName();

        //普通动作列表
        List<SysAction> normalActionList = actionService.findActionListByMenuIdAndType(menuId, 1);

        //授权动作列表
        List<SysAction> authorActionList = actionService.findActionListByMenuIdAndType(menuId, 2);

        /*model.addAttribute("menu",menu);
        model.addAttribute("parentMenu",parentMenu);
        model.addAttribute("subMenuList",subMenuList);
        model.addAttribute("ListUrl",ListUrl);
        model.addAttribute("normalActionList",normalActionList);
        model.addAttribute("authorActionList",authorActionList);

        return "dev/menu_detail";*/
        HashMap<String, Object> map = new HashMap<>();
        map.put("menu",menu);
        map.put("parentMenu",parentMenu);
        map.put("subMenuList",subMenuList);
        map.put("ListUrl",ListUrl);
        map.put("normalActionList",normalActionList);
        map.put("authorActionList",authorActionList);
        return map;
    }

    @RequestMapping("/menu/menuManage_toEditMenu.do")
    public String menuManage_toEditMenu(Integer menuId,Integer parentId,Integer actionId,Model model){
        //菜单
        SysMenu menu = menuService.findMenuById(menuId);
        //parent菜单
        SysMenu parentMenu = menuService.findMenuById(parentId);
        //菜单类型列表
        List<MenuType> menuTypeList = new ArrayList<>();
        menuTypeList.add(new MenuType(1,"一级菜单"));
        menuTypeList.add(new MenuType(2,"二级菜单"));

        model.addAttribute("menu",menu);
        model.addAttribute("parentMenu",parentMenu);
        model.addAttribute("menuTypeList",menuTypeList);
        return "dev/menu_edit";
    }


    @RequestMapping("/menu/menuManage_editMenu.do")
    public String menuManage_editMenu(SysMenu menu){
        menuService.update(menu);
        if(menu!=null){
            actionService.update(menu.getSysAction());
        }
        return "forward:/menu/menu_detail";
    }

    @RequestMapping("/menu/toAddSubMenu")
    public String toAddSubMenu(Integer menuId,Integer type,Model model){

        //菜单(作为parent菜单)
        SysMenu menu = menuService.findMenuById(menuId);
        //菜单类型列表
        List<MenuType> menuTypeList = new ArrayList<>();
        menuTypeList.add(new MenuType(1,"一级菜单"));
        menuTypeList.add(new MenuType(2,"二级菜单"));

        model.addAttribute("menu",menu);
        model.addAttribute("menuTypeList",menuTypeList);

        return "dev/menu_add";
    }

    @RequestMapping("/menu/addMenu")
    public String addMenu(SysMenu menu, HttpServletRequest req){
        menuService.add(menu);

        req.setAttribute("overrideMenuId",true);
        req.setAttribute("menuId",menu.getParentId());
        return "forward:/menu/menu_detail";
    }


    /**
     * 点击删除菜单
     */
    @RequestMapping("/menu/menuManage_delMenu.do")
    public String menuManage_delMenu(Integer menuId,Integer parentId,Integer type,HttpServletRequest req){
        menuService.delete(menuId);
        req.setAttribute("overrideMenuId",true);
        req.setAttribute("menuId",parentId);
        return "forward:/menu/menu_detail";
    }

    /**
     * 点击添加动作
     */
    @RequestMapping("/menu/toAddAction")
    public String toAddAction(Integer menuId,Model model){
        SysMenu menu = menuService.findMenuById(menuId);
        model.addAttribute("menu",menu);

        return "dev/action_add";
    }

    /**
     * 添加动作的确定
     */
    @RequestMapping("/menu/addAction")
    public String addAction(SysAction sysAction, HttpServletRequest req){
        actionService.add(sysAction);

        req.setAttribute("overrideMenuId",true);
        req.setAttribute("menuId",sysAction.getMenuId());
        return "forward:/menu/menu_detail";
    }

    /**
     * 点击编辑动作
     */
    @RequestMapping("/menu/menuManage_toEditAction.do")
    public String menuManage_toEditAction(Integer actionId,Integer menuId,Model model){
        SysAction action = actionService.findByActionId(actionId);
        SysMenu menu = menuService.findMenuById(menuId);

        model.addAttribute("action",action);
        model.addAttribute("menu",menu);
        return "dev/action_edit";
    }

    /**
     * 点击编辑动作的确定提交
     */
    @RequestMapping("/menu/menuManage_editAction.do")
    public String menuManage_editAction(SysAction sysAction, HttpServletRequest req){
        actionService.update(sysAction);

        req.setAttribute("overrideMenuId",true);
        req.setAttribute("menuId",sysAction.getMenuId());
        return "forward:/menu/menu_detail";
    }

    /**
     * 点击删除动作
     */
    @RequestMapping("/menu/menuManage_delAction.do")
    public String menuManage_delAction(Integer actionId,Integer menuId,HttpServletRequest req){
        actionService.deleteByActionId(actionId);

        req.setAttribute("overrideMenuId",true);
        req.setAttribute("menuId",menuId);
        return "forward:/menu/menu_detail";
    }

}
