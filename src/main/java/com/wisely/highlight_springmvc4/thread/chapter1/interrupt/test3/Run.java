package com.wisely.highlight_springmvc4.thread.chapter1.interrupt.test3;

/**
 * Created by dujiayong on 2019/2/24.
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("main catch");
        }
        System.out.println("end !!!!");
    }
}
