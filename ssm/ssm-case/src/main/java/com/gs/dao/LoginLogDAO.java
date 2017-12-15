package com.gs.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDAO extends BaseDAO {

    void updateByUserId(Long userId);
}
