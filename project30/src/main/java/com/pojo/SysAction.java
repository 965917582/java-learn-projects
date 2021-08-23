package com.pojo;

public class SysAction {
    private Integer actionId;
    private String actionName;
    private Integer type;
    private Integer menuId;
    private String remark;
    public static final Integer ACTIONTYPE_NORMAL = 1;
    public static final Integer ACTIONTYPE_AUTHOR = 2;

    public SysAction() {
    }

    public SysAction(Integer actionId, String actionName, Integer type, Integer menuId, String remark) {
        this.actionId = actionId;
        this.actionName = actionName;
        this.type = type;
        this.menuId = menuId;
        this.remark = remark;
    }

    public Integer getACTIONTYPE_NORMAL() {
        return ACTIONTYPE_NORMAL;
    }

    public Integer getACTIONTYPE_AUTHOR() {
        return ACTIONTYPE_AUTHOR;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Sysaction{" +
                "actionId=" + actionId +
                ", actionName='" + actionName + '\'' +
                ", type=" + type +
                ", menuId=" + menuId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
