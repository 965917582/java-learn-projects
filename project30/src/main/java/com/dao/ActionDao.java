package com.dao;

import com.pojo.SysAction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao {
    List<String> findAllName();

    List<String> findAllNameByRoleId(Integer roleId);

    List<String> findAllNameByType(Integer type);

    List<SysAction> findActionListByMenuIdAndType(Integer menuId, Integer type);

    SysAction findByActionId(Integer actionId);

    List<SysAction> findActionListByMenuId(Integer menuId);

    void updateActionName(SysAction sysaction);

    void setMenuId(SysAction sysaction);

    void update(SysAction sysaction);

    void add(SysAction sysaction);

    void deleteByActionId(Integer actionId);

    void deleteByMenuId(Integer menuId);

}
