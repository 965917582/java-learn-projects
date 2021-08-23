package com.pojo.base;

import java.io.Serializable;

public class Dept implements Serializable {

    private Integer deptId;
    private String deptName;
    private String deptAddr;
    private String deptPhone;
    private String deptContact;
    private String deptDesc;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public String getDeptPhone() {
        return deptPhone;
    }

    public void setDeptPhone(String deptPhone) {
        this.deptPhone = deptPhone;
    }

    public String getDeptContact() {
        return deptContact;
    }

    public void setDeptContact(String deptContact) {
        this.deptContact = deptContact;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptAddr='" + deptAddr + '\'' +
                ", deptPhone='" + deptPhone + '\'' +
                ", deptContact='" + deptContact + '\'' +
                ", deptDesc='" + deptDesc + '\'' +
                '}';
    }
}
