package com.gs.dao;

import com.gs.common.Pager;

import java.util.List;

/**
 * 数据访问的父接口
 * @param <T>
 */
public interface BaseDAO<T> {

    /**
     * 保存数据
     * @param t
     */
    void save(T t);
    void remove(T t);
    void removeById(Long id);
    void active(Long id, Byte status);
    void update(T t);

    T getById(Long id);
    List<T> listAll();
    Pager<T> listPager(Pager<T> pager);
    Long count();
    Pager<T> listPagerCriteria(Pager<T> pager, T t);
    Long countCriteria(T t);

}
