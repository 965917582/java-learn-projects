package com.service.impl;

import com.dao.ActionDao;
import com.dao.MenuDao;
import com.pojo.SysMenu;
import com.pojo.SysAction;
import com.pojo.User;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;
    @Autowired
    ActionDao actionDao;
    @Override
    public List<SysMenu> getMenuTree() {
        List<SysMenu> menu = menuDao.findByParentId(0);
        this.findSubMenu(menu,0,-1);
        return menu;
    }


    @Override
    public List<SysMenu> getMenuTreeByRole(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginUser");

        List<SysMenu> menu = menuDao.findByParentIdAndRoleId(user.getRoleId(), 0);
        this.findSubMenu(menu,2,user.getRoleId());
        return menu;
    }

    @Override
    public List<SysMenu> getMenuTreeWithoutAction() {
        List<SysMenu> menu = menuDao.findByParentIdWithoutAction(0);
        this.findSubMenu(menu,1,-1);
        return menu;
    }

    @Override
    public SysMenu findMenuById(Integer menuId) {
        return menuDao.findByMenuId(menuId);
    }

    @Override
    public List<SysMenu> findSubMenuList(Integer parentId) {
        return menuDao.findByParentId(parentId);
    }

    @Override
    public void update(SysMenu menu) {
        menuDao.update(menu);
    }

    @Override
    public void add(SysMenu menu) {
        //需要添加一条菜单和一条动作
        if(menu.getActionName()==null){
            menu.setActionName("default");
        }

        SysAction sysaction = new SysAction(null,menu.getActionName(),1,menu.getMenuId(),null);
        actionDao.add(sysaction);
        menu.setActionId(sysaction.getActionId());
        menuDao.add(menu);
        //别忘了给动作设menuId
        sysaction.setMenuId(menu.getMenuId());
        actionDao.setMenuId(sysaction);
    }


    //递归填充当前菜单列表的子菜单列表，当flag为0时每个菜单需要关联得到动作信息，为1时不需要
    private void findSubMenu(List<SysMenu> menu,int flag,int roleId){
        for (SysMenu m : menu) {
            List<SysMenu> list = null;

            if(flag==0){
                list = menuDao.findByParentId(m.getMenuId());
            }else if(flag==1){
                list = menuDao.findByParentIdWithoutAction(m.getMenuId());
            }else if(flag==2){
                list = menuDao.findByParentIdAndRoleId(roleId,m.getMenuId());
            }

            if(list.size()==0 && flag==1){
                m.setSubMenuList(null);
            }else{
                m.setSubMenuList(list);    
            }

            if(list.size()==0){
                continue;
            }
            this.findSubMenu(list,flag,roleId);
        }
    }


    @Override
    public void delete(Integer menuId) {
        //需要迭代删除所有后代菜单，和相关动作
        List<SysMenu> list = menuDao.findByParentIdWithoutAction(menuId);
        //删除其后代菜单
        this.deleteSubMenu(list);
        //删除它本身和它关联的动作
        menuDao.deleteByMenuId(menuId);
        actionDao.deleteByMenuId(menuId);

    }

    //递归删除列表中所有菜单的子菜单
    private void deleteSubMenu(List<SysMenu> list){
        if(list==null || list.size()==0){
            return;
        }
        for (SysMenu menu : list) {
            List<SysMenu> subs = menuDao.findByParentIdWithoutAction(menu.getMenuId());
            this.deleteSubMenu(subs);

            //先删子菜单，才能再删parent菜单(因为数据库子菜单对parent菜单有依赖)
            menuDao.deleteByMenuId(menu.getMenuId());
            //同时删除相关动作
            actionDao.deleteByMenuId(menu.getMenuId());
        }
    }




}
