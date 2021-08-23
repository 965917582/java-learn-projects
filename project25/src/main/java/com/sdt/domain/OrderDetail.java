package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail  implements Serializable {
    private Integer orderDetailId;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodsNum;
    private BigDecimal goodsPrice;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
