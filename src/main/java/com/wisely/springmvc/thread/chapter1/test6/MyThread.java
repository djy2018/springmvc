package com.wisely.springmvc.thread.chapter1.test6;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread extends Thread {

    private int i = 5;

    @Override
    public void run() {
        // 虽然println方法内部是同步的，但是i--操作是进入println方法之前发生的
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }

}
