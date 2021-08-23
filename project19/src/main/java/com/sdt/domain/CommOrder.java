package com.sdt.domain;

import java.io.Serializable;

public class CommOrder implements Serializable {
    private Integer orderId;

    private Integer commId;

    private Integer commOrderNum;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getCommOrderNum() {
        return commOrderNum;
    }

    public void setCommOrderNum(Integer commOrderNum) {
        this.commOrderNum = commOrderNum;
    }

    @Override
    public String toString() {
        return "CommOrder{" +
                "orderId=" + orderId +
                ", commId=" + commId +
                ", commOrderNum=" + commOrderNum +
                '}';
    }
}
