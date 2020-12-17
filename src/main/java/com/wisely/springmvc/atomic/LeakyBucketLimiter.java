package com.wisely.springmvc.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 漏桶算法
 *
 * @author dujiayong
 * @date 2020/12/16 16:18
 */
public class LeakyBucketLimiter {

    private static final Logger logger = LoggerFactory.getLogger(LeakyBucketLimiter.class);

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // 桶的容量
    public int capacity = 10;

    // 当前水量
    public int water = 0;

    // 水流速度/s
    public int rate = 4;

    // 最后一次加水时间
    public long lastTime = System.currentTimeMillis();

    /**
     * 线程池每 1s 发送随机数量的请求，每次请求计算当前桶内的水量及剩余容量，请求数量超出当前桶容量，则产生限
     */
    public void acquire() {
        Runnable task = () -> {
            long now = System.currentTimeMillis();
            // 计算当前水量
            water = Math.max(0, (int) (water - (now - lastTime) * rate / 1000));
            int permits = (int) (Math.random() * 8) + 1;
            logger.info("请求数:" + permits + ",当前余量:" + (capacity - water));
            lastTime = now;
            if (capacity - water < permits) {
                // 如果桶已经满了，则拒绝
                logger.info("限流了");
            } else {
                // 还有容量
                water += permits;
                logger.info("剩余容量=" + (capacity - water));
            }
        };
        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 1000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        LeakyBucketLimiter limiter = new LeakyBucketLimiter();
        limiter.acquire();
    }

}
