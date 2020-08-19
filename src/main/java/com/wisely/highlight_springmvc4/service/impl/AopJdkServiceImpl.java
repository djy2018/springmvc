package com.wisely.highlight_springmvc4.service.impl;

import com.wisely.highlight_springmvc4.service.AopJdkService;
import org.springframework.stereotype.Service;

@Service
public class AopJdkServiceImpl implements AopJdkService {

    @Override
    public void select() {
        System.out.println("using JdkDynamicProxy ... select");
    }

}
