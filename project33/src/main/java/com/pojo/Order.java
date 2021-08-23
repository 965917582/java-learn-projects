package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class Order {
    private Integer order_id;
    private String appkey;
    private Integer user_order_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date train_date;
    private Integer is_accept_standing=1;
    private String choose_seats="无";
    private String from_station_code;
    private String to_station_code;
    private String checi;
    private String paymentAccount;
    private String passengers;
    private Integer status=2;//占座成功为2，出票成功为4

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public Integer getUser_order_id() {
        return user_order_id;
    }

    public void setUser_order_id(Integer user_order_id) {
        this.user_order_id = user_order_id;
    }

    public Date getTrain_date() {
        return train_date;
    }

    public void setTrain_date(Date train_date) {
        this.train_date = train_date;
    }

    public Integer getIs_accept_standing() {
        return is_accept_standing;
    }

    public void setIs_accept_standing(Integer is_accept_standing) {
        this.is_accept_standing = is_accept_standing;
    }

    public String getChoose_seats() {
        return choose_seats;
    }

    public void setChoose_seats(String choose_seats) {
        this.choose_seats = choose_seats;
    }

    public String getFrom_station_code() {
        return from_station_code;
    }

    public void setFrom_station_code(String from_station_code) {
        this.from_station_code = from_station_code;
    }

    public String getTo_station_code() {
        return to_station_code;
    }

    public void setTo_station_code(String to_station_code) {
        this.to_station_code = to_station_code;
    }

    public String getCheci() {
        return checi;
    }

    public void setCheci(String checi) {
        this.checi = checi;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", appkey='" + appkey + '\'' +
                ", user_order_id=" + user_order_id +
                ", train_date=" + train_date +
                ", is_accept_standing=" + is_accept_standing +
                ", choose_seats='" + choose_seats + '\'' +
                ", from_station_code='" + from_station_code + '\'' +
                ", to_station_code='" + to_station_code + '\'' +
                ", checi='" + checi + '\'' +
                ", paymentAccount='" + paymentAccount + '\'' +
                ", passengers='" + passengers + '\'' +
                ", status=" + status +
                '}';
    }
}
