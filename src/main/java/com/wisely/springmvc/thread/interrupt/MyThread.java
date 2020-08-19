package com.wisely.springmvc.thread.interrupt;

/**
 * Created by dujiayong on 2018/8/11.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 15000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
