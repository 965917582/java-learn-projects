package com.service;

import com.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    List<Integer> findActionIdByRoleId(Integer roleId);

    List<Integer> findMenuIdByRoleId(Integer roleId);

    void savePrivs(Integer roleId, List<Integer> menuIds, List<Integer> actionIds);
}
