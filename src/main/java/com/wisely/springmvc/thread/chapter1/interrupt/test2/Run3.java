package com.wisely.springmvc.thread.chapter1.interrupt.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1);
            myThread.interrupt();
            System.out.println("是否停止 1 ? =" + myThread.isInterrupted());
            System.out.println("是否停止 2 ? =" + myThread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!!!");
    }
}
