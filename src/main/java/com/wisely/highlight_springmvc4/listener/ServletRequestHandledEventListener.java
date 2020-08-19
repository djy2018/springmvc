package com.wisely.highlight_springmvc4.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author dujiayong
 * @date   2020/7/7
 **/
@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {

    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        System.out.println("请求相关信息==="+event.getDescription());
        System.out.println("访问路径==="+event.getRequestUrl());
        System.out.println("请求系统响应花费时间==="+event.getProcessingTimeMillis());
        System.out.println("请求发生时间==="+event.getTimestamp());
        System.out.println("请求失败原因异常==="+event.getFailureCause());
        System.out.println("请求响应HTTP状态值==="+event.getStatusCode());
    }

}
