package org.allen.demo.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-02-12 17:23
 */
public class MyTask1 extends QuartzJobBean {

    private DateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyTask1 执行时间：" + df.format(new Date()));
    }

}
