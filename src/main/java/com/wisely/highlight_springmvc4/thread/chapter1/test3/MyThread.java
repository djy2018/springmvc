package com.wisely.highlight_springmvc4.thread.chapter1.test3;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0){
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算，得到：" + count);
        }
    }

}
