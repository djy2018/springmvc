package com.wisely.springmvc.thread.chapter1.interrupt.test4;

/**
 * Created by dujiayong on 2019/2/24.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            System.out.println("111111111111");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止 !进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
