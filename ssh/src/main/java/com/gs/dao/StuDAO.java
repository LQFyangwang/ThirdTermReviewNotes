package com.gs.dao;

import com.gs.bean.Stu;
import com.gs.vo.StuVO;

import java.util.List;

public interface StuDAO extends BaseDAO<Stu> {

    List<StuVO> listAllWithClass();

}
