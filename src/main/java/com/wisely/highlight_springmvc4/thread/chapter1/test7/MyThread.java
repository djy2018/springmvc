package com.wisely.highlight_springmvc4.thread.chapter1.test7;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread extends Thread {

    public MyThread() {
        System.out.println("构造方法被打印:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法被打印:" + Thread.currentThread().getName());
    }

}
