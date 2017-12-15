package com.gs.service;

import com.gs.bean.Stu;
import com.gs.vo.StuVO;

import java.util.List;

public interface StuService extends BaseService<Stu> {
    List<StuVO> listAllWithClass();
}
