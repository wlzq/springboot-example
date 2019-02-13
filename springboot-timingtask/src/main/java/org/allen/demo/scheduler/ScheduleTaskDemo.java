package org.allen.demo.scheduler;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-02-12 10:06
 */
@Component
public class ScheduleTaskDemo {

    private int num1 = 0;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test1(){
        System.out.println("这是test1方法第"+ (++num1) + "次执行，执行时间："+df.format(new Date()));
    }

    /**
     * 上一次开始执行时间点之后 6 秒再执行
     */
    //@Scheduled(fixedRate = 5000)
    public void test2(){
        System.out.println("这是test2方法第"+ (++num1) + "次执行，执行时间："+df.format(new Date()));
    }

    /**
     * 上一次执行完毕时间点之后5秒再执行
     */
    //@Scheduled(fixedDelay = 5)
    public void test3(){
        System.out.println("这是test2方法第"+ (++num1) + "次执行，执行时间："+df.format(new Date()));
    }

    /**
     * 第一次延迟1秒后执行，之后按照fixedRate的规则执行
     */
    //@Scheduled(initialDelay = 1, fixedDelay = 6)
    public void test4(){
        System.out.println("这是test2方法第"+ (++num1) + "次执行，执行时间："+df.format(new Date()));
    }

}
