package com.gs.service.impl;

import com.gs.common.Pager;
import com.gs.dao.CashDAO;
import com.gs.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashServiceImpl implements CashService {

    @Autowired
    private CashDAO cashDAO;

    @Override
    public void save(Object obj) {
        cashDAO.save(obj);
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
        cashDAO.update(obj);
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
        return null;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        Pager pager = new Pager(pageNo, pageSize);
        pager.setRows(cashDAO.listPagerCriteria(pager, obj));
        pager.setTotal(cashDAO.countCriteria(obj));
        return pager;
    }
}
