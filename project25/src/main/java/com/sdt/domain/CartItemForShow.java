package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用于展示单条购物车信息的bean
 */
public class CartItemForShow implements Serializable {
    private Integer cartid;
    private String shopname;
    private String shoppic;
    private BigDecimal price;
    private String guige;
    private Integer shopnum;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShoppic() {
        return shoppic;
    }

    public void setShoppic(String shoppic) {
        this.shoppic = shoppic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

    @Override
    public String toString() {
        return "CartItemForShow{" +
                "cartid=" + cartid +
                ", shopname='" + shopname + '\'' +
                ", shoppic='" + shoppic + '\'' +
                ", price=" + price +
                ", guige='" + guige + '\'' +
                ", shopnum=" + shopnum +
                '}';
    }
}
