package com.pojo;

public class EmpType {
    private String type;
    private String empTypeName;

    public EmpType(String type, String empTypeName) {
        this.type = type;
        this.empTypeName = empTypeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmpTypeName() {
        return empTypeName;
    }

    public void setEmpTypeName(String empTypeName) {
        this.empTypeName = empTypeName;
    }

    @Override
    public String toString() {
        return "empType{" +
                "type=" + type +
                ", empTypeName='" + empTypeName + '\'' +
                '}';
    }
}
