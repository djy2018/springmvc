package com.wisely.springmvc.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dujiayong on 2020/4/5.
 */
@Aspect
@Component
public class UserServiceAspect {

    @Pointcut("execution(* com.wisely.highlight_springmvc4.service..*.*(..))")
    public void log() {

    }

    @Around(value = "log()")
    public Object logTime(ProceedingJoinPoint joinPoint) {
        Object object = null;
        try {
            long start = System.currentTimeMillis();
            object = joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}
