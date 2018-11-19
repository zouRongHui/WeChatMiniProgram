package org.rone.study.springBoot.async;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * spring线程池的初始化配置
 * create by rone
 * 2018.11.13
 */
@Component
@EnableAsync
public class ThreadAsyncConfigurer implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPool.setCorePoolSize(5);
        // 设置最大线程数
        threadPool.setMaxPoolSize(10);
        // 线程池所使用的缓冲队列
        threadPool.setQueueCapacity(5);
        /*tip:
            任务排队策略：优先使用core核心线程，当超出时塞入到queue中，
            当queue满了时，用max-core的线程来处理，当max个线程全用掉了，会触发RejectedExecutionHandler设置的处理机制*/
        // 等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        //
        threadPool.setAwaitTerminationSeconds(60 * 0);
        // 当线程池已满(corePool用完，queue中已满，maxPool资源也用完)时新任务的处理机制
        //      ThreadPoolExecutor.AbortPolicy[默认值]：丢弃任务，抛运行时异常
        //      ThreadPoolExecutor.CallerRunsPolicy：由调用者线程处理新任务
        //      ThreadPoolExecutor.DiscardPolicy：忽略
        //      ThreadPoolExecutor.DiscardOldestPolicy：从队列中挤掉最先进入队列的那个任务
        //      实现RejectedExecutionHandler接口，可自定义处理器
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 是否允许为核心线程设置超时销毁
        threadPool.setAllowCoreThreadTimeOut(true);
        // 线程名称前缀
        threadPool.setThreadNamePrefix("MyAsync-");
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }
}
