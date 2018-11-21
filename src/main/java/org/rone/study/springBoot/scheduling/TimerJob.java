package org.rone.study.springBoot.scheduling;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;

/**
 * 相比简单的@Scheduled ，此方案可动态修改执行时间
 */
@Component
public class TimerJob implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 设置定时任务并发执行(多任务并发执行，单任务的多次执行是串行)
        // 当项目中存在多个SchedulingConfigurer的实现类用来实现定时任务时，
        //      并发池的配置仅需配置一个即可，@Scheduled实现的任务也会并发执行
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(20));
        //添加定时任务
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println("==============开始定时任务============" + new Date());
            System.out.println(Thread.currentThread().getName());
            //定时任务
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==============定时任务完成============"+ new Date());
        }, triggerContext -> {
            //可以通过 return null 来控制定时任务是否继续执行，也可以自己手动的控制下一次执行的时间
//            if (true) {
//                return null;
//            }

            //遵循cornTrigger规则
            String cron = "0/10 * * * * ?";
            CronTrigger cronTrigger = new CronTrigger(cron);
            Date nextTime = cronTrigger.nextExecutionTime(triggerContext);
            System.out.println("下次执行任务的时间是： " + nextTime);

            return nextTime;
        });
        //可以同时添加多个任务
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println("==============开始第二个任务============" + new Date());
            //定时任务
            try {
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==============第二个任务完成============" + new Date());
        }, triggerContext -> {
            String cron = "0/10 * * * * ?";
            CronTrigger cronTrigger = new CronTrigger(cron);
            Date nextTime = cronTrigger.nextExecutionTime(triggerContext);
            System.out.println("下次执行第二个任务的时间是： " + nextTime);

            return nextTime;
        });
    }

}
