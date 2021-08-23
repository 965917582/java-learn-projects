package com.pojo;

import java.math.BigDecimal;

public class OrderPassenger {
    private String phoneNum;
    private String email;
    private String passengerid;
    private String passengersename;
    private String piaotype;
    private String piaotypename;
    private String passporttypeseid;
    private String passporttypeseidname;
    private String passportseno;
    private String price;
    private String zwcode;
    private String zwname;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(String passengerid) {
        this.passengerid = passengerid;
    }

    public String getPassengersename() {
        return passengersename;
    }

    public void setPassengersename(String passengersename) {
        this.passengersename = passengersename;
    }

    public String getPiaotype() {
        return piaotype;
    }

    public void setPiaotype(String piaotype) {
        this.piaotype = piaotype;
    }

    public String getPiaotypename() {
        return piaotypename;
    }

    public void setPiaotypename(String piaotypename) {
        this.piaotypename = piaotypename;
    }

    public String getPassporttypeseid() {
        return passporttypeseid;
    }

    public void setPassporttypeseid(String passporttypeseid) {
        this.passporttypeseid = passporttypeseid;
    }

    public String getPassporttypeseidname() {
        return passporttypeseidname;
    }

    public void setPassporttypeseidname(String passporttypeseidname) {
        this.passporttypeseidname = passporttypeseidname;
    }

    public String getPassportseno() {
        return passportseno;
    }

    public void setPassportseno(String passportseno) {
        this.passportseno = passportseno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getZwcode() {
        return zwcode;
    }

    public void setZwcode(String zwcode) {
        this.zwcode = zwcode;
    }

    public String getZwname() {
        return zwname;
    }

    public void setZwname(String zwname) {
        this.zwname = zwname;
    }

    @Override
    public String toString() {
        return "OrderPassenger{" +
                "phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", passengerid='" + passengerid + '\'' +
                ", passengersename='" + passengersename + '\'' +
                ", piaotype='" + piaotype + '\'' +
                ", piaotypename='" + piaotypename + '\'' +
                ", passporttypeseid='" + passporttypeseid + '\'' +
                ", passporttypeseidname='" + passporttypeseidname + '\'' +
                ", passportseno='" + passportseno + '\'' +
                ", price='" + price + '\'' +
                ", zwcode='" + zwcode + '\'' +
                ", zwname='" + zwname + '\'' +
                '}';
    }
}
