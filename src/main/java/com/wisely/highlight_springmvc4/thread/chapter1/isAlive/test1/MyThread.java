package com.wisely.highlight_springmvc4.thread.chapter1.isAlive.test1;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("run ==" + this.isAlive());
    }

}
