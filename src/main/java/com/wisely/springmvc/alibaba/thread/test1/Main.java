package com.wisely.springmvc.alibaba.thread.test1;

/**
 * Created by dujiayong on 2018/6/28
 */
public class Main {

    public static void main(String[] args) {
        Test1Resource resource = new Test1Resource();
        new Thread(new Number(resource,1)).start();
        new Thread(new Character(resource,2)).start();
    }
}
