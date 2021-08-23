package com.pojo;

public class NotifyUrl {

    private Integer id;
    private String appkey;
    private String submit_callback;
    private String pay_callback;
    private String refund_callback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSubmit_callback() {
        return submit_callback;
    }

    public void setSubmit_callback(String submit_callback) {
        this.submit_callback = submit_callback;
    }

    public String getPay_callback() {
        return pay_callback;
    }

    public void setPay_callback(String pay_callback) {
        this.pay_callback = pay_callback;
    }

    public String getRefund_callback() {
        return refund_callback;
    }

    public void setRefund_callback(String refund_callback) {
        this.refund_callback = refund_callback;
    }

    @Override
    public String toString() {
        return "NotifyUrl{" +
                "id=" + id +
                ", appkey='" + appkey + '\'' +
                ", submit_callback='" + submit_callback + '\'' +
                ", pay_callback='" + pay_callback + '\'' +
                ", refund_callback='" + refund_callback + '\'' +
                '}';
    }
}
