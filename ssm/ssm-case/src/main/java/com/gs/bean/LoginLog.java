package com.gs.bean;

import java.sql.Timestamp;

public class LoginLog {
    private Long id;
    private Long userId;
    private Timestamp loginTime;
    private Timestamp logoutTime;
    private String loginIp;
    private Short isOnline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Short getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Short isOnline) {
        this.isOnline = isOnline;
    }

    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }
}
