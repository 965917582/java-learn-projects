package com.sdt.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private Integer orderId;

    private Date orderSubmitTime;

    private List<Commodit> orderCommodits;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderSubmitTime() {
        return orderSubmitTime;
    }

    public void setOrderSubmitTime(Date orderSubmitTime) {
        this.orderSubmitTime = orderSubmitTime;
    }

    public List<Commodit> getOrderCommodits() {
        return orderCommodits;
    }

    public void setOrderCommodits(List<Commodit> orderCommodits) {
        this.orderCommodits = orderCommodits;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderd=" + orderId +
                ", orderSubmitTime=" + orderSubmitTime +
                '}';
    }
}
