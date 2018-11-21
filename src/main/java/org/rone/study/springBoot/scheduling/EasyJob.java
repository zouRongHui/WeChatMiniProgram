package org.rone.study.springBoot.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 单线程执行，当上一次任务没完成时，下一次任务是不会触发的
 */
@Component
public class EasyJob {

    /**
     * 支持以下形式定时
     * 1. cron = "0/5 * * * * ?"    cron表达式
     * 2. fixedDelay = 1000*10      该任务执行完后间隔10s后再次执行
     * 3. fixedRate = 1000*10       10s执行一次，如果上个任务完成时已超出此次开始的时间则立即执行
     */
//    @Scheduled(cron = "0/5 * * * * ?")
    public void easyJob() {
        System.out.println("简单的单线程任务" + new Date());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
