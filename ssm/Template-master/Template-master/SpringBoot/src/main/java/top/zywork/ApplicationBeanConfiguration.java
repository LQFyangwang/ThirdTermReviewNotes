package top.zywork;

import com.alibaba.druid.pool.DruidDataSource;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.zywork.constant.AppLoadConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * Spring Boot注册自定义Bean组件的类<br />
 * 创建于2017-08-31
 * @author 王振宇
 * @version 1.0
 */
@Configuration
public class ApplicationBeanConfiguration {

    @Value("${appConfigLocation}")
    private String appConfigLocation;

    /**
     * ServletContext初始化Bean，由此Bean设置监听器的初始化参数
     * @return 带有自定义context-param的ServletContext初始化对象
     */
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter(AppLoadConstants.CONFIG_LOCATION, appConfigLocation);
            }
        };
    }

    /**
     * 注册DozerMapper bean
     * @return dozerMapper，需要使用dozerMapper的类直接@Resource或@Autowired自动封装
     */
    @Bean
    public DozerBeanMapperFactoryBean getDozerMapper() {
        return new org.dozer.spring.DozerBeanMapperFactoryBean();
    }

    /**
     * 注册DruidDataSource bean
     * @return 由application.yml文件中指定的Datasource配置信息的DruidDataSource对象
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

}
