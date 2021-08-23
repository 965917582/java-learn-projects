package com.sdt.pojo;

import java.math.BigDecimal;

public class ReqPram {

    private Integer out_trade_no;
    private String product_code = "FAST_INSTANT_TRADE_PAY";
    private BigDecimal total_amount;
    private String subject ;

    public Integer getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(Integer out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
