package com.wisely.springmvc.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopServiceTest {

    @Test
    public void aopTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop.xml");
//        AopService aopService = (AopService) applicationContext.getBean("aopServiceImpl");
//        AopService aopService = applicationContext.getBean(AopService.class);
//        aopService.select();
        AopJdkService aopJdkService = applicationContext.getBean(AopJdkService.class);
        aopJdkService.select();

    }

}
