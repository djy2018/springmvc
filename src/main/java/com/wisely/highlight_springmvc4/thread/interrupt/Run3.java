package com.wisely.highlight_springmvc4.thread.interrupt;

/**
 * Created by dujiayong on 2018/8/11.
 */
public class Run3 {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1);
            thread.interrupt();
            System.out.println("是否停止1：" + thread.isInterrupted());
            System.out.println("是否停止2：" + thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        } finally {
            System.out.println("end!");
        }
    }
}
