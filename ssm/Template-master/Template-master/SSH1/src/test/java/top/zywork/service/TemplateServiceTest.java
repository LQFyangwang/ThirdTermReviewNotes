package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.zywork.common.EncryptUtils;
import top.zywork.dto.TemplateDTO;

import javax.annotation.Resource;

/**
 * Template服务测试类<br />
 * 创建于2017-08-24
 *
 * @author 王振宇
 */
@ContextConfiguration(locations = {"classpath:/config/spring-template.xml",
        "classpath:/config/spring-hibernate.xml",
        "classpath:/config/spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateServiceTest {

    @Resource
    private TemplateService templateService;

    @Test
    public void testSave() {
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setName("test");
        templateDTO.setPassword(EncryptUtils.md5("123456"));
        templateService.save(templateDTO);
    }
}
