package com.gs.service;

import com.gs.common.Pager;
import com.gs.query.CashQuery;
import com.gs.vo.CashVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CashServiceTest extends BaseTest {

    @Autowired
    private CashService cashService;

    @Test
    public void testListPagerCriteria() {
        CashQuery cashQuery = new CashQuery();
        cashQuery.setMoney(new BigDecimal(600));
        cashQuery.setCashTime("2017-12-08 10:00:00");
        Pager pager = cashService.listPagerCriteria(1, 2, cashQuery);
        System.out.println(((CashVO)pager.getRows().get(0)).getId());
    }
}
