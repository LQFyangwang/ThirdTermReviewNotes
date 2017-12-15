package com.gs.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Cash {
    private Long id;
    private BigDecimal money;
    private String customer;
    private Long cashType;
    private Timestamp cashTime;
    private Long payType;
    private Long userId;
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Timestamp getCashTime() {
        return cashTime;
    }

    public void setCashTime(Timestamp cashTime) {
        this.cashTime = cashTime;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
}
