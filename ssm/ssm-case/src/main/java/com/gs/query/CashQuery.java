package com.gs.query;

import java.math.BigDecimal;

public class CashQuery {

    private BigDecimal money;
    private String customer;
    private Long cashType;
    private Long payType;
    private String cashTime;
    private String createTime;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getCashType() {
        return cashType;
    }

    public void setCashType(Long cashType) {
        this.cashType = cashType;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public String getCashTime() {
        return cashTime;
    }

    public void setCashTime(String cashTime) {
        this.cashTime = cashTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
