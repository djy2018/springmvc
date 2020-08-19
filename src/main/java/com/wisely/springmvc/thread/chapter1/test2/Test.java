package com.wisely.springmvc.thread.chapter1.test2;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(1);
        MyThread myThread2 = new MyThread(2);
        MyThread myThread3 = new MyThread(3);
        MyThread myThread4 = new MyThread(4);
        MyThread myThread5 = new MyThread(5);
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();
        myThread1.run();
        myThread2.run();
        myThread3.run();
        myThread4.run();
        myThread5.run();
        System.out.println("程序结束!!!");
    }
}
