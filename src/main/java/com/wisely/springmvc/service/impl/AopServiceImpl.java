package com.wisely.springmvc.service.impl;

import com.wisely.springmvc.service.AopService;

public class AopServiceImpl implements AopService {

    @Override
    public void select() {
        System.out.println("Spring aop - select...");
    }

    @Override
    public void insert() {
        System.out.println("Spring aop - insert...");
    }

}
