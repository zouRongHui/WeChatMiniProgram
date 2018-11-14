package org.rone.study.springBoot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {

    /**
     * 有@Async注解的方法，默认就是异步执行的，会在默认的线程池中执行，但是此方法不能在本类调用；
     * 调用类需添加@EnableAsync
     */
    @Async
    public void test() {
        System.out.println("子线程名称：" + Thread.currentThread().getName() + "----------");
        try {
            Thread.sleep(1000 * 10);
            System.out.println("子线程over.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
