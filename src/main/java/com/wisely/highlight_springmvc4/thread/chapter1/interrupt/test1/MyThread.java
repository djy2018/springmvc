package com.wisely.highlight_springmvc4.thread.chapter1.interrupt.test1;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
