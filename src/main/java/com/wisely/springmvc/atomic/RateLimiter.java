package com.wisely.springmvc.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Source:https://xilidou.com/2018/02/01/java-cas/
 *
 * @author dujiayong
 * @date 2020/12/14 10:55
 */
public class RateLimiter {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiter.class);

    private final long rateToMsConversion;

    private final AtomicInteger consumedTokens = new AtomicInteger();

    private final AtomicLong lastRefillTime = new AtomicLong(0L);

    public RateLimiter(TimeUnit averageRateUnit) {
        switch (averageRateUnit) {
            case SECONDS:
                rateToMsConversion = 1000;
                break;
            case MINUTES:
                rateToMsConversion = 60 * 1000;
                break;
            default:
                throw new IllegalArgumentException("TimeUnit of " + averageRateUnit + " is not supported");
        }
    }

    public boolean acquire(int burstSize, long averageRate) {
        return acquire(burstSize, averageRate, System.currentTimeMillis());
    }

    public boolean acquire(int burstSize, long averageRate, long currentTimeMillis) {
        if (burstSize <= 0 || averageRate <= 0) {
            // Instead of throwing exception,we just let all the traffic go
            return true;
        }

        // add token
        refillToken(burstSize, averageRate, currentTimeMillis);

        // consume token
        return consumeToken(burstSize);
    }

    private void refillToken(int burstSize, long averageRate, long currentTimeMillis) {
        long refillTime = lastRefillTime.get();
        long timeDelta = currentTimeMillis - refillTime;

        // calculate the needing added number of token by rate
        long newTokens = timeDelta * averageRate / rateToMsConversion;
        if (newTokens > 0) {
            long newRefillTime = refillTime == 0 ? currentTimeMillis : refillTime + newTokens * rateToMsConversion / averageRate;

            // CAS 保证有且仅有一个一个线程进入填充
            if (lastRefillTime.compareAndSet(refillTime, newRefillTime)) {
                while (true) {
                    int currentLevel = consumedTokens.get();
                    // In case burstSize decreased
                    int adjustedLevel = Math.min(currentLevel, burstSize);
                    int newLevel = (int) Math.max(0, adjustedLevel - newTokens);
                    // while true 直到更新成功为止
                    if (consumedTokens.compareAndSet(currentLevel, newLevel)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean consumeToken(int burstSize) {
        while (true) {
            int currentLevel = consumedTokens.get();
            if (currentLevel >= burstSize) {
                return false;
            }

            // while true 直到没有token 或者 获取到为止
            if (consumedTokens.compareAndSet(currentLevel, currentLevel + 1)) {
                return true;
            }
        }
    }

    public void reset() {
        consumedTokens.set(0);
        lastRefillTime.set(0);
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(TimeUnit.SECONDS);

        int averageRate = 2;

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            int random = (int) (Math.random() * 8) + 1;
            boolean result = rateLimiter.acquire(random, averageRate);
            logger.info("请求token数量:" + random + ",是否获取成功:" + result);
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

}
