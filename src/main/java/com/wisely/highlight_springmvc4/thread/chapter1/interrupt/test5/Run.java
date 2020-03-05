package com.wisely.highlight_springmvc4.thread.chapter1.interrupt.test5;

/**
 * Created by dujiayong on 2019/2/24.
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("222222222222222222");
        thread.interrupt();
        System.out.println("end!!");
    }
}
