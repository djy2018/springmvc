package com.wisely.springmvc.thread.chapter1.interrupt.test5;

/**
 * Created by dujiayong on 2019/2/24.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i=" + (i+1));
            }
            System.out.println("run begin");
            System.out.println("111111111111111");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到了sleep!进入catch!");
            e.printStackTrace();
        }
    }
}
