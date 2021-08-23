package com.pojo;
//乘客[实名认证时]
public class Passenger {
    private String passenger_name;
    private String email="965917582@qq.com";
    private Integer passenger_id_type_code = 1;
    private String passenger_id_type_name = "二代身份证";
    private String passenger_id_no;
    private String encMobileNo;

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPassenger_id_type_code() {
        return passenger_id_type_code;
    }

    public void setPassenger_id_type_code(Integer passenger_id_type_code) {
        this.passenger_id_type_code = passenger_id_type_code;
    }

    public String getPassenger_id_type_name() {
        return passenger_id_type_name;
    }

    public void setPassenger_id_type_name(String passenger_id_type_name) {
        this.passenger_id_type_name = passenger_id_type_name;
    }

    public String getPassenger_id_no() {
        return passenger_id_no;
    }

    public void setPassenger_id_no(String passenger_id_no) {
        this.passenger_id_no = passenger_id_no;
    }

    public String getEncMobileNo() {
        return encMobileNo;
    }

    public void setEncMobileNo(String encMobileNo) {
        this.encMobileNo = encMobileNo;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_name='" + passenger_name + '\'' +
                ", email='" + email + '\'' +
                ", passenger_id_type_code=" + passenger_id_type_code +
                ", passenger_id_type_name='" + passenger_id_type_name + '\'' +
                ", passenger_id_no='" + passenger_id_no + '\'' +
                ", encMobileNo='" + encMobileNo + '\'' +
                '}';
    }
}
