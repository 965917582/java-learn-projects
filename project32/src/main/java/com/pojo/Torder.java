package com.pojo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Torder {
    private Integer order_id;
    private Integer user_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date train_date;
    private Integer is_accept_standing=1;
    private String choose_seats="无";
    private String from_station_code;
    private String to_station_code;
    private String checi;
    private Integer status=0;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Torder{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", train_date=" + train_date +
                ", is_accept_standing=" + is_accept_standing +
                ", choose_seats='" + choose_seats + '\'' +
                ", from_station_code='" + from_station_code + '\'' +
                ", to_station_code='" + to_station_code + '\'' +
                ", checi='" + checi + '\'' +
                ", status=" + status +
                '}';
    }
}
