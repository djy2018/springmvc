package com.wisely.highlight_springmvc4.thread.chapter1.isAlive.test1;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin ==" + myThread.isAlive());
        myThread.start();
        Thread.sleep(1000);
        System.out.println("end ==" + myThread.isAlive());
    }

}
