package com.controller;

import com.pojo.Role;
import com.pojo.SysAction;
import com.pojo.SysMenu;
import com.service.ActionService;
import com.service.MenuService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrivController {

    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;
    @Autowired
    ActionService actionService;

    @RequestMapping("/priv/privManage_init")
    public String privManage_init(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "system/privilege";
    }

    @RequestMapping("/priv/privManage_loadTree")
    @ResponseBody
    public List<SysMenu> privManage_loadTree(){
        List<SysMenu> menuTree = menuService.getMenuTree();
        return menuTree;
    }

    @RequestMapping("/priv/privManage_loadAction")
    @ResponseBody
    public List<SysAction> privManage_loadAction(Integer menuId){
        List<SysAction> actionList = actionService.findActionListByMenuId(menuId);
        return actionList;
    }

    @RequestMapping("/priv/privManage_loadPrivs")
    @ResponseBody
    public List<List<Integer>> privManage_loadPrivs(Integer roleId){
        List<Integer> actionList = roleService.findActionIdByRoleId(roleId);
        List<Integer> menuList = roleService.findMenuIdByRoleId(roleId);
        List<List<Integer>> list = new ArrayList<>();
        list.add(menuList);
        list.add(actionList);
        return list;
    }

    @RequestMapping("/priv/privManage_savePrivs")
    @ResponseBody
    public String privManage_savePrivs(Integer roleId , @RequestParam("menuIds")List<Integer> menuIds, @RequestParam("actionIds")List<Integer> actionIds){
        roleService.savePrivs(roleId,menuIds,actionIds);
        return "succ";
    }
}
