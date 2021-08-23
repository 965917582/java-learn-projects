package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private Integer orderId;
    private Integer orderStatus;
    private Integer userId;
    private BigDecimal orderTotalPrice;

    private Date orderCreateTime;
    private Date orderPayTime;
    private Date orderSendTime;
    private Date orderReceiveTime;
    private Date orderDoneTime;

    private List<CartItem> goodsList;

    public List<CartItem> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CartItem> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Date getOrderSendTime() {
        return orderSendTime;
    }

    public void setOrderSendTime(Date orderSendTime) {
        this.orderSendTime = orderSendTime;
    }

    public Date getOrderReceiveTime() {
        return orderReceiveTime;
    }

    public void setOrderReceiveTime(Date orderReceiveTime) {
        this.orderReceiveTime = orderReceiveTime;
    }

    public Date getOrderDoneTime() {
        return orderDoneTime;
    }

    public void setOrderDoneTime(Date orderDoneTime) {
        this.orderDoneTime = orderDoneTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", userId=" + userId +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderCreateTime=" + orderCreateTime +
                ", orderPayTime=" + orderPayTime +
                ", orderSendTime=" + orderSendTime +
                ", orderReceiveTime=" + orderReceiveTime +
                ", orderDoneTime=" + orderDoneTime +
                '}';
    }
}
