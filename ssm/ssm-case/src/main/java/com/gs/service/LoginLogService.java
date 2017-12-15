package com.gs.service;

public interface LoginLogService extends BaseService {

    void save(Long userId, String ip);
    void updateByUserId(Long userId);
}
