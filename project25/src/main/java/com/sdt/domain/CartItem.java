package com.sdt.domain;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Integer shopid;
    private Integer userid;
    private Integer shopnum;
    private String shopname;
    private String shopprice;

    public String getShopprice() {
        return shopprice;
    }

    public void setShopprice(String shopprice) {
        this.shopprice = shopprice;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "shopid=" + shopid +
                ", userid=" + userid +
                ", shopnum=" + shopnum +
                '}';
    }
}
