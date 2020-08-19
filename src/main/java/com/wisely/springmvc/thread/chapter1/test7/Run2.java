package com.wisely.springmvc.thread.chapter1.test7;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.start();
        myThread.run();
    }

}
