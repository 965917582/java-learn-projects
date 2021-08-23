package com.pojo;

import java.math.BigDecimal;

public class OrderPassenger {
    private Integer order_passenger_id;
    private Integer order_id;
    private Integer passengerid;
    private String passengersename;
    private Integer piaotype;
    private Integer passporttypeseid;
    private String passportseno;
    private BigDecimal price;
    private String zwcode;

    public Integer getOrder_passenger_id() {
        return order_passenger_id;
    }

    public void setOrder_passenger_id(Integer order_passenger_id) {
        this.order_passenger_id = order_passenger_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Integer passengerid) {
        this.passengerid = passengerid;
    }

    public String getPassengersename() {
        return passengersename;
    }

    public void setPassengersename(String passengersename) {
        this.passengersename = passengersename;
    }

    public Integer getPiaotype() {
        return piaotype;
    }

    public void setPiaotype(Integer piaotype) {
        this.piaotype = piaotype;
    }

    public Integer getPassporttypeseid() {
        return passporttypeseid;
    }

    public void setPassporttypeseid(Integer passporttypeseid) {
        this.passporttypeseid = passporttypeseid;
    }

    public String getPassportseno() {
        return passportseno;
    }

    public void setPassportseno(String passportseno) {
        this.passportseno = passportseno;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getZwcode() {
        return zwcode;
    }

    public void setZwcode(String zwcode) {
        this.zwcode = zwcode;
    }

    @Override
    public String toString() {
        return "OrderPassenger{" +
                "order_passenger_id=" + order_passenger_id +
                ", order_id=" + order_id +
                ", passengerid=" + passengerid +
                ", passengersename='" + passengersename + '\'' +
                ", piaotype=" + piaotype +
                ", passporttypeseid=" + passporttypeseid +
                ", passportseno='" + passportseno + '\'' +
                ", price=" + price +
                ", zwcode='" + zwcode + '\'' +
                '}';
    }
}
