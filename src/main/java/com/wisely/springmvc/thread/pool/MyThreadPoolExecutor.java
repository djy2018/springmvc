package com.wisely.springmvc.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dujiayong on 2020/3/1.
 */
@Configuration
@EnableAsync // 开启对异步任务支持
public class MyThreadPoolExecutor implements AsyncConfigurer{

    private static final Logger log = LoggerFactory.getLogger(MyThreadPoolExecutor.class);

    /**
     * 实现AsyncConfigurer接口，重写getAsyncExecutor方法，自定义线程池
     * 重写getAsyncUncaughtExceptionHandler，自定义异常处理类
     * @return
     */
    @Bean(name = "asyncExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
        asyncExecutor.setCorePoolSize(5);
        asyncExecutor.setMaxPoolSize(100);
        asyncExecutor.setKeepAliveSeconds(60);
        asyncExecutor.setQueueCapacity(100);
        asyncExecutor.setThreadNamePrefix("asyncExecutor-custom-");
        // 当pool已经达到max size的时候，如何处理新任务，不在新线程中执行，而是由调用者所在的线程执行
        asyncExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return asyncExecutor;
    }

    /**
     * 自定义线程池:ThreadPoolTaskExecutor，返回参数类型:ThreadPoolTaskExecutor
     * @return
     */
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("MyThreadPoolExecutor-custom-");
        // 当pool已经达到max size的时候，如何处理新任务，不在新线程中执行，而是由调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异常处理类
     */
    static class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.error("Exception message - " + throwable.getMessage());
            log.error("Method name - " + method.getName());
            for(Object param:objects){
                log.error("Parameter value -" + param);
            }
        }
    }
}
