package com.gs.service;

import com.gs.bean.Stu;
import com.gs.bean.StuDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StuDetailServiceTest extends BaseTest {

    @Autowired
    private StuDetailService stuDetailService;

    @Test
    public void testSave() {
        Stu stu = new Stu();
        stu.setId(6L);
        StuDetail stuDetail = new StuDetail();
        stuDetail.setId(6L);
        //stuDetail.setStu(stu);
        stuDetail.setGender((byte) 1);
        stuDetail.setPhone("1111");
        stuDetail.setIdentityNo("66669");
        stuDetailService.update(stuDetail);
    }

}
