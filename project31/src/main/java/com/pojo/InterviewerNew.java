package com.pojo;

import java.util.Date;

public class InterviewerNew {

    private Integer interviewerid;//面试者主键id

    private String name;//姓名

    private String age;//年龄

    private String nativeplace;//住址

    private String currentposition;//当前职位

    private String educationinformation;//学历信息

    private String telephone;//电话

    private String wechat;//微信

    private Date entrytime;//确认时间

    public Integer getInterviewerid() {
        return interviewerid;
    }

    public void setInterviewerid(Integer interviewerid) {
        this.interviewerid = interviewerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public String getCurrentposition() {
        return currentposition;
    }

    public void setCurrentposition(String currentposition) {
        this.currentposition = currentposition == null ? null : currentposition.trim();
    }

    public String getEducationinformation() {
        return educationinformation;
    }

    public void setEducationinformation(String educationinformation) {
        this.educationinformation = educationinformation == null ? null : educationinformation.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    @Override
    public String toString() {
        return "InterviewerNew{" +
                "interviewerid=" + interviewerid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", nativeplace='" + nativeplace + '\'' +
                ", currentposition='" + currentposition + '\'' +
                ", educationinformation='" + educationinformation + '\'' +
                ", telephone='" + telephone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", entrytime=" + entrytime +
                '}';
    }
}
