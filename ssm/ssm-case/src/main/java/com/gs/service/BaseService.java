package com.gs.service;

import com.gs.common.Pager;

import java.util.List;

public interface BaseService {

    void save(Object obj);
    void remove(Object obj);
    void removeById(Long id);
    void active(Long id, Byte status);
    void update(Object obj);

    Object getById(Long id);
    List<Object> listAll();
    Pager listPager(int pageNo, int pageSize);

    Pager listPagerCriteria(int pageNo, int pageSize, Object obj);

}
