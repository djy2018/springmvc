package com.wisely.springmvc.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dujiayong on 2020/4/5.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.wisely.springmvc.service"})
public class UserServiceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(UserServiceTest.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
//        UserServiceImpl userService = (UserServiceImpl) annotationConfigApplicationContext.getBean("userService");
        userService.login(1);
    }

}