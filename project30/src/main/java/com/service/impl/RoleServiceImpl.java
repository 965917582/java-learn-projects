package com.service.impl;

import com.dao.RoleDao;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public List<Integer> findActionIdByRoleId(Integer roleId) {
        return roleDao.findActionIdByRoleId(roleId);
    }

    @Override
    public List<Integer> findMenuIdByRoleId(Integer roleId) {
        return roleDao.findMenuIdByRoleId(roleId);
    }

    @Override
    public void savePrivs(Integer roleId,List<Integer> menuIds, List<Integer> actionIds) {
        //先删除此角色的菜单和动作
        roleDao.deleteMenuRelationByRoleId(roleId);
        roleDao.deleteActionRelationByRoleId(roleId);

        //添加新提交的角色的菜单和动作
        for (Integer menuId : menuIds) {
            roleDao.addMenuByRoleId(roleId,menuId);
        }
        for (Integer actionId : actionIds) {
            roleDao.addActionByRoleId(roleId,actionId);
        }
    }
}
