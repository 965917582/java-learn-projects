package com.pojo;

import java.io.Serializable;

public class RoleAuthAction implements Serializable {
    private Integer roleAuthActionId;
    private Integer roleId;
    private Integer actionId;

    public Integer getRoleAuthActionId() {
        return roleAuthActionId;
    }

    public void setRoleAuthActionId(Integer roleAuthActionId) {
        this.roleAuthActionId = roleAuthActionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    @Override
    public String toString() {
        return "RoleAuthAction{" +
                "roleAuthActionId=" + roleAuthActionId +
                ", roleId=" + roleId +
                ", actionId=" + actionId +
                '}';
    }
}
