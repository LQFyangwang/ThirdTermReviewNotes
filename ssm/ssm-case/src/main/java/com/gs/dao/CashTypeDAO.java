package com.gs.dao;

import com.gs.vo.CashTypeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashTypeDAO extends BaseDAO {

    List<CashTypeVO> listByPid(Long pid);

}
