package com.wisely.springmvc.thread.chapter1.sleep.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run1 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin =" + System.currentTimeMillis());
        myThread1.start();
        System.out.println("end =" + System.currentTimeMillis());
    }
}
