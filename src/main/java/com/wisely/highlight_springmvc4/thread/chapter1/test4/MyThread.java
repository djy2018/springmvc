package com.wisely.highlight_springmvc4.thread.chapter1.test4;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class MyThread extends Thread {

    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算，得到count=" + count);
    }

}
