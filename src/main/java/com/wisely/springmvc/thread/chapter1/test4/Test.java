package com.wisely.springmvc.thread.chapter1.test4;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread threadA = new Thread(myThread,"A");
        Thread threadB = new Thread(myThread,"B");
        Thread threadC = new Thread(myThread,"C");
        Thread threadD = new Thread(myThread,"D");
        Thread threadE = new Thread(myThread,"E'");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
