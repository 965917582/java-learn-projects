package com.sdt.domain;

import java.io.Serializable;

public class Commodit implements Serializable {
    private Integer commId;

    private String commName;

    private Double commPrice;

    private Integer commNum;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Double getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(Double commPrice) {
        this.commPrice = commPrice;
    }

    public Integer getCommNum() {
        return commNum;
    }

    public void setCommNum(Integer commNum) {
        this.commNum = commNum;
    }

    @Override
    public String toString() {
        return "Commodit{" +
                "commId=" + commId +
                ", commName='" + commName + '\'' +
                ", commPrice=" + commPrice +
                '}';
    }
}
