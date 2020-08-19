package com.wisely.springmvc.service.impl;

import com.wisely.springmvc.service.AopJdkService;
import org.springframework.stereotype.Service;

@Service
public class AopJdkServiceImpl implements AopJdkService {

    @Override
    public void select() {
        System.out.println("using JdkDynamicProxy ... select");
    }

}
