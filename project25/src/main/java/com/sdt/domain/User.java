package com.sdt.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userid;
    private String account;
    private String uname;
    private String pwd;
    private String repwd;//确认密码

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRepwd() {
        return repwd;
    }

    public void setRepwd(String repwd) {
        this.repwd = repwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", account='" + account + '\'' +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", repwd='" + repwd + '\'' +
                '}';
    }
}
