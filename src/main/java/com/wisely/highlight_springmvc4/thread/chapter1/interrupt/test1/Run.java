package com.wisely.highlight_springmvc4.thread.chapter1.interrupt.test1;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
