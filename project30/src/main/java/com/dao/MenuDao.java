package com.dao;

import com.pojo.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    List<SysMenu> findByParentId(Integer id);

    List<SysMenu> findByParentIdAndRoleId(Integer roleId, Integer parentId);

    List<SysMenu> findByParentIdWithoutAction(Integer id);

    SysMenu findByMenuId(Integer id);

    void update(SysMenu menu);

    void add(SysMenu menu);

    void deleteByMenuId(Integer menuId);
}
