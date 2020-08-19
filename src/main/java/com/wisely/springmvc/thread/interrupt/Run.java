package com.wisely.springmvc.thread.interrupt;

/**
 * Created by dujiayong on 2018/8/11.
 */
public class Run {

    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            System.out.println("是否停止 1 ? = " + Thread.interrupted());
            System.out.println("是否停止 2 ? = " + Thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end !");
    }
}
