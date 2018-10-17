package org.rone.study.springBoot.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 单线程执行，当上一次任务没完成时，下一次任务是不会触发的
 */
@Component
public class EasyJob {

    @Scheduled(cron = "0/5 * * * * ?")
    public void easyJob() {
        System.out.println("简单的单线程任务" + new Date());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
