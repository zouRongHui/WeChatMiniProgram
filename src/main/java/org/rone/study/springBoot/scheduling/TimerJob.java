package org.rone.study.springBoot.scheduling;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 多线程的任务，每次都会额外开启一个线程去执行任务，不管上一次任务有没有完成
 */
@Component
public class TimerJob implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println("==============开始定时任务============");
            //定时任务
            try {
                System.out.println("休眠3秒钟");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==============定时任务完成============");
        }, triggerContext -> {
            //遵循cornTrigger规则
            String cron = "0/5 * * * * ?";
            CronTrigger cronTrigger = new CronTrigger(cron);
            Date nextTime = cronTrigger.nextExecutionTime(triggerContext);
            System.out.println("下次执行任务的时间是： " + nextTime);

            return nextTime;
        });
        //可以同时添加多个任务
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println("==============开始第二个任务============");
            //定时任务
            try {
                System.out.println("休眠1分钟");
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==============第二个任务完成============");
        }, triggerContext -> {
            String cron = "0 0/3 * * * ?";
            CronTrigger cronTrigger = new CronTrigger(cron);
            Date nextTime = cronTrigger.nextExecutionTime(triggerContext);
            System.out.println("下次执行第二个任务的时间是： " + nextTime);

            return nextTime;
        });
    }
}
