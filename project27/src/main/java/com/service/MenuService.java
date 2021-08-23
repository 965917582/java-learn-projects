package com.service;

import com.pojo.SysMenu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenuService {

    //得到菜单树(含动作对象的信息)
    public List<SysMenu> getMenuTree();

    //根据角色 得到菜单树(含动作对象的信息)
    public List<SysMenu> getMenuTreeByRole(HttpServletRequest req);

    //得到菜单树(不含动作对象的信息)
    public List<SysMenu> getMenuTreeWithoutAction();

    //根据id得到菜单对象(含动作对象)
    public SysMenu findMenuById(Integer menuId);

    //根据parentId得到子菜单对象列表(含动作对象)
    public List<SysMenu> findSubMenuList(Integer parentId);

    //更新菜单
    public void update(SysMenu menu);

    //添加一项菜单
    void add(SysMenu menu);

    //删除一项菜单
    void delete(Integer menuId);
}
