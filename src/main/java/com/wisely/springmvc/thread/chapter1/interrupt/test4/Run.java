package com.wisely.springmvc.thread.chapter1.interrupt.test4;

/**
 * Created by dujiayong on 2019/2/24.
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(200);
            System.out.println("222222222222222222");
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end !!!");
    }
}
