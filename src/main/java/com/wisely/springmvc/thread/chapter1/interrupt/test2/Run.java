package com.wisely.springmvc.thread.chapter1.interrupt.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(10000);
            myThread.interrupt();
            System.out.println("是否停止 1 ? =" + Thread.interrupted());
            System.out.println("是否停止 2 ? =" + Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!!!");
    }
}
