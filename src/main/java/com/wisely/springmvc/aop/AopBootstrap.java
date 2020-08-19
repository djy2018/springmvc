package com.wisely.springmvc.aop;

import com.wisely.springmvc.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dujiayong on 2020/4/4.
 */
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AopBootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoService.class);
        DemoService demoService = applicationContext.getBean(DemoService.class);
        demoService.saySomething();
    }

}
