package com.pojo;

public class User {
    private Integer user_id;
    private String account;
    private String pwd;
    private String realname;
    private String phone;
    private String email;
    private String passenger_id_no;
    private String bankCardNo;
    private String bankCardMobile;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassenger_id_no() {
        return passenger_id_no;
    }

    public void setPassenger_id_no(String passenger_id_no) {
        this.passenger_id_no = passenger_id_no;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankCardMobile() {
        return bankCardMobile;
    }

    public void setBankCardMobile(String bankCardMobile) {
        this.bankCardMobile = bankCardMobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passenger_id_no='" + passenger_id_no + '\'' +
                ", bankCardNo='" + bankCardNo + '\'' +
                ", bankCardMobile='" + bankCardMobile + '\'' +
                '}';
    }
}
