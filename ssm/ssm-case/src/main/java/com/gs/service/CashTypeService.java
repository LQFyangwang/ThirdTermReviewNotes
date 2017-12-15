package com.gs.service;

import com.gs.vo.CashTypeVO;

import java.util.List;

public interface CashTypeService extends BaseService {

    List<CashTypeVO> listByPid(Long pid);
}
