package com.sdt.domain;

import java.io.Serializable;

/**
 * 购物车条目bean
 * 所选商品引用
 * 购买数量
 */
public class CartItem  implements Serializable {
    private Commodit commodit;

    private Integer commoditNum;

    public Commodit getCommodit() {
        return commodit;
    }

    public void setCommodit(Commodit commodit) {
        this.commodit = commodit;
    }

    public Integer getCommoditNum() {
        return commoditNum;
    }

    public void setCommoditNum(Integer commoditNum) {
        this.commoditNum = commoditNum;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "commodit=" + commodit +
                ", commoditNum=" + commoditNum +
                '}';
    }
}
