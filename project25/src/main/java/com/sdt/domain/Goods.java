package com.sdt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    private Integer shopid;
    private String shopname;
    private String goodsDesc;
    private String shoppic;
    private String goodsDetail;
    private BigDecimal price;
    private Integer goodsStock;
    private Integer xiaoliang;
    private String guige;

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getShoppic() {
        return shoppic;
    }

    public void setShoppic(String shoppic) {
        this.shoppic = shoppic;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getXiaoliang() {
        return xiaoliang;
    }

    public void setXiaoliang(Integer xiaoliang) {
        this.xiaoliang = xiaoliang;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "shopid=" + shopid +
                ", shopname='" + shopname + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", shoppic='" + shoppic + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", price=" + price +
                ", goodsStock=" + goodsStock +
                ", xiaoliang=" + xiaoliang +
                ", guige='" + guige + '\'' +
                '}';
    }
}
