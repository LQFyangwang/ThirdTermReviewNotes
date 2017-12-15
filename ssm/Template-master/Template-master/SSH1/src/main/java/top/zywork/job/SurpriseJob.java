package top.zywork.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * quartz job示例，直接继承自QuartzJobBean<br />
 * 创建于2017-09-22
 *
 * @author 王振宇
 * @version 1.0
 */
public class SurpriseJob extends QuartzJobBean {

    private String name;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("surprise!" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
