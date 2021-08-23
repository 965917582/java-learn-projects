package com.dao;

import com.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> findAll();

    List<Integer> findActionIdByRoleId(Integer roleId);

    public List<String> dinfAllNameByRoleId(Integer roleId);

    List<Integer> findMenuIdByRoleId(Integer roleId);

    void addActionByRoleId(Integer roleId, Integer actionId);

    void addMenuByRoleId(Integer roleId, Integer menuId);

    void deleteMenuRelationByRoleId(Integer roleId);

    void deleteActionRelationByRoleId(Integer roleId);
}
