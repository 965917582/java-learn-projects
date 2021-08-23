package com.pojo;

import java.util.List;

public class SysMenu {
    private Integer menuId;
    private String menuName;
    private Integer type;
    private Integer actionId;
    private Integer parentId;
    private String remark;

    private List<SysMenu> subMenuList;
    private SysAction sysAction;
    private String actionName;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SysMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SysMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public SysAction getSysAction() {
        return sysAction;
    }

    public void setSysAction(SysAction sysAction) {
        this.sysAction = sysAction;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", type=" + type +
                ", actionId=" + actionId +
                ", parentId=" + parentId +
                ", remark='" + remark + '\'' +
                ", subMenuList=" + subMenuList +
                ", sysAction=" + sysAction +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}
