package com.july.mymall.commodityservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);         // 核心线程数
        executor.setMaxPoolSize(100);         // 最大线程数
        executor.setQueueCapacity(1000);      // 队列容量
        executor.setThreadNamePrefix("async-");
        executor.initialize();
        return executor;
    }
}
