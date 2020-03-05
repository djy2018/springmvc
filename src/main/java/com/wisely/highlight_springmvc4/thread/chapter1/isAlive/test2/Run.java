package com.wisely.highlight_springmvc4.thread.chapter1.isAlive.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run {

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());
    }
}
