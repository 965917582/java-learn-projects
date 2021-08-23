package com.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPsd;
    private Integer userRole;

    public User(){

    }

    public User(String userName,String userPsd){
        this.userName=userName;
        this.userPsd=userPsd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPsd='" + userPsd + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
