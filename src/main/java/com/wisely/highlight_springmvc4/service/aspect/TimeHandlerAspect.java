package com.wisely.highlight_springmvc4.service.aspect;

public class TimeHandlerAspect {

    public void printTime(){
        System.out.println("Spring Aop 当前时间为:" + System.currentTimeMillis());
    }

}
