package com.wisely.highlight_springmvc4.thread.chapter1.test3;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class Test {

    public static void main(String[] args) {
        MyThread threadA = new MyThread("A");
        MyThread threadB = new MyThread("B");
        MyThread threadC = new MyThread("C");
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
