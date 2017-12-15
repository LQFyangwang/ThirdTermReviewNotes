package com.gs.service;

import com.gs.bean.Clazz;
import com.gs.bean.Stu;
import com.gs.bean.StuDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StuServiceTest extends BaseTest {

    @Autowired
    private StuService stuService;

    @Test
    public void testSave() {
        Stu stu = new Stu();
        stu.setNum("160203");
        stu.setRealName("小明");
        Clazz clazz = new Clazz();
        clazz.setId(1L);
        stu.setClazz(clazz);

        StuDetail stuDetail = new StuDetail();
        stuDetail.setIdentityNo("8888");
        stuDetail.setPhone("18888888888");
        stuDetail.setGender((byte) 0);

        stu.setStuDetail(stuDetail);
        stuDetail.setStu(stu);

        stuService.save(stu);
    }

}
