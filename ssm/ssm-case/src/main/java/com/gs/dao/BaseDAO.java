package com.gs.dao;

import com.gs.common.Pager;

import java.util.List;

/**
 * 数据访问的父接口
 */
public interface BaseDAO {

    void save(Object obj);
    void remove(Object obj);
    void removeById(Long id);
    void active(Long id, Byte status);
    void update(Object obj);

    Object getById(Long id);
    List<Object> listAll();
    List<Object> listPager(Pager pager);
    Long count();
    List<Object> listPagerCriteria(Pager pager, Object obj);
    Long countCriteria(Object obj);

}
