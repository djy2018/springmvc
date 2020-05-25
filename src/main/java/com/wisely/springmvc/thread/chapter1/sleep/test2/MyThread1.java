package com.wisely.springmvc.thread.chapter1.sleep.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread1 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run threadName="
                    + this.currentThread().getName() + " begin="
                    + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName="
                    + this.currentThread().getName() + " end="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
