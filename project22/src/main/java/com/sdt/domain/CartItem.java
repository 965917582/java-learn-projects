package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 在商品页面添加一个商品到购物车时的数据bean
 * 包含用户id，商品id，数量，添加时价格，商品名称(展示时方便直接在redis获取而不用查数据库)
 *
 */
public class CartItem implements Serializable {
    private String goodsName;
    private Integer goodsId;
    private Integer userId;
    private Integer goodsNum;//所选数量
    private BigDecimal goodsPrice;//购买时价格

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "CartItem{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", goodsNum=" + goodsNum +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
