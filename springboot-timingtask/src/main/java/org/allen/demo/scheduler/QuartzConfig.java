package org.allen.demo.scheduler;

import org.quartz.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-02-12 14:49
 */
@SpringBootConfiguration
public class QuartzConfig {

    @Bean
    public JobDetail myTask1JobDetail(){
        return JobBuilder.newJob(MyTask1.class).withIdentity("myTask1").storeDurably().build();
    }

    @Bean
    public Trigger myTask1Trigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //5秒执行一次
                .withIntervalInSeconds(5)
                .repeatForever();
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                //指定触发器对应的JobDetail
                .forJob(myTask1JobDetail())
                .withIdentity("myTask1")
                .withSchedule(scheduleBuilder).build();
        return trigger;
    }

    @Bean
    public JobDetail myTask2JobDetail(){
        return JobBuilder.newJob(MyTask2.class).withIdentity("myTask2").storeDurably().build();
    }

    @Bean
    public Trigger myTask2Trigger(){
        //cron 表达式
        String cronStr = "*/10 * * * * ?";
        //根据表达式设置ScheduleBuilder
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronStr);
        CronTrigger trigger = TriggerBuilder.newTrigger()
                //指定JobDetail
                .forJob(myTask2JobDetail())
                .withIdentity("myTask2")
                //指定ScheduleBuilder
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;
    }

}
