package com.gs.service.impl;

import com.gs.bean.LoginLog;
import com.gs.common.Pager;
import com.gs.dao.LoginLogDAO;
import com.gs.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDAO loginLogDAO;

    @Override
    public void save(Object obj) {
        loginLogDAO.save(obj);
    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void active(Long id, Byte status) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public Object getById(Long id) {
        return null;
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        Pager pager = new Pager(pageNo, pageSize);
        pager.setRows(loginLogDAO.listPager(pager));
        pager.setTotal(loginLogDAO.count());
        return pager;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        return null;
    }

    @Override
    public void save(Long userId, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(userId);
        loginLog.setIsOnline((short) 1);
        loginLog.setLoginTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        loginLog.setLoginIp(ip);
        loginLogDAO.save(loginLog);
    }

    @Override
    public void updateByUserId(Long userId) {
        loginLogDAO.updateByUserId(userId);
    }
}
