package com.pojo;

import java.io.Serializable;

public class Action implements Serializable {
    private Integer actionId;
    private String actionName;
    private Integer actionType;
    private String actionDesc;
    private Integer actionBelongMenu;

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

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public Integer getActionBelongMenu() {
        return actionBelongMenu;
    }

    public void setActionBelongMenu(Integer actionBelongMenu) {
        this.actionBelongMenu = actionBelongMenu;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", actionName='" + actionName + '\'' +
                ", actionType=" + actionType +
                ", actionDesc='" + actionDesc + '\'' +
                ", actionBelongMenu=" + actionBelongMenu +
                '}';
    }
}
