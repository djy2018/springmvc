package com.wisely.highlight_springmvc4.thread.chapter1.test2;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class MyThread extends Thread {

    private int i;

    public MyThread(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
