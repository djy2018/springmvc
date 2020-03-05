package com.wisely.highlight_springmvc4.thread.chapter1.test1;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
