package com.wisely.highlight_springmvc4.service;

import org.springframework.stereotype.Service;

/**
 * Created by dujiayong on 2016/7/7.
 */
@Service
public class DemoService {

    public String saySomething(){
        System.out.println("hello world!!!");
        return "hello";
    }

}
