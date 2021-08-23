package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartForShow implements Serializable {
    private BigDecimal totalpri;
    List<CartItemForShow> shoplist;

    public BigDecimal getTotalpri() {
        return totalpri;
    }

    public void setTotalpri(BigDecimal totalpri) {
        this.totalpri = totalpri;
    }

    public List<CartItemForShow> getShoplist() {
        return shoplist;
    }

    public void setShoplist(List<CartItemForShow> shoplist) {
        this.shoplist = shoplist;
    }
}
