package com.gs.service;

import com.gs.bean.User;

public interface UserService extends BaseService {

    User getByPhonePwd(String phone, String pwd);

}
