package com.wisely.springmvc.thread.chapter1.test5;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        ThreadB threadB = new ThreadB();
        threadB.start();
    }
}
