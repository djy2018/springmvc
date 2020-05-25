package com.wisely.springmvc.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dujiayong on 2020/3/2.
 */
@RestController
@RequestMapping(value = "/threadPoolTest")
public class ThreadPoolTestController {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @RequestMapping(value = "/stat")
    public String stat() {
        for (int i = 0; i < 10; i++) {
            threadPoolTaskExecutor.execute(() -> {
                try {
                    Thread.sleep(1000 * 2);
                    System.out.println("当前时间:" + System.currentTimeMillis() + ",线程:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("结束...,时间:" + System.currentTimeMillis());
        return "success";
    }

}
