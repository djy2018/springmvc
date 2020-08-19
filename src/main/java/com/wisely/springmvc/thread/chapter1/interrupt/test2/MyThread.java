package com.wisely.springmvc.thread.chapter1.interrupt.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
//            System.out.println("i=" + (i + 1));
        }
    }
}
