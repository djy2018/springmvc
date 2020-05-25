package com.wisely.springmvc.thread.chapter1.test8;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run {

    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread t1 = new Thread(countOperate);
        t1.setName("A");
        t1.start();
    }

}
