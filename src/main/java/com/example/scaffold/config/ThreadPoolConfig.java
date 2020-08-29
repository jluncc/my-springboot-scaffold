package com.example.scaffold.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置类，使用Spring封装的ThreadPoolTaskExecutor
 *
 * Created by jinglun on 2020-07-18
 */
@Configuration
public class ThreadPoolConfig {

    // 核心线程数（默认线程数）
    @Value("${common.thread-pool.core-pool-size}")
    private int CORE_POOL_SIZE;

    // 最大线程数
    @Value("${common.thread-pool.max-pool-size}")
    private int MAX_POOL_SIZE;

    // 允许线程空闲时间（单位：默认为秒）
    @Value("${common.thread-pool.keep-alive-time}")
    private int KEEP_ALIVE_TIME;

    // 缓冲队列大小
    @Value("${common.thread-pool.queue-capacity}")
    private int QUEUE_CAPACITY;

    // 线程池名前缀
    @Value("${common.thread-pool.thread-name-prefix}")
    private String THREAD_NAME_PREFIX = "async-thread-";

    @Bean("myTaskExecutor") // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);

        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }

}
