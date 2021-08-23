package com.pojo;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    private Integer roleMenuId;
    private Integer roleId;
    private Integer menuId;

    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleMenuId=" + roleMenuId +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                '}';
    }
}
