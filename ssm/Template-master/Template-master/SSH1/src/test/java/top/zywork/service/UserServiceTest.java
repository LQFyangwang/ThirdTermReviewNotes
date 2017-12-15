package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.zywork.common.EncryptUtils;
import top.zywork.dto.TemplateDTO;
import top.zywork.dto.UserDTO;
import top.zywork.query.UserAccountPasswordQuery;

import javax.annotation.Resource;

/**
 * 用户服务测试类<br />
 * 创建于2017-09-05
 *
 * @author 王振宇
 */
@ContextConfiguration(locations = {"classpath:/config/spring-user.xml",
        "classpath:/config/spring-hibernate.xml",
        "classpath:/config/spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetByAccountPassword() {
        UserAccountPasswordQuery query = new UserAccountPasswordQuery("wgssmarter@126.com", "123456");
        UserDTO userDTO = userService.getByAccountPassword(query);
        System.out.println(userDTO.getId());
    }
}
