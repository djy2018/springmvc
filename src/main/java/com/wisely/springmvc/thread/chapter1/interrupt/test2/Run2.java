package com.wisely.springmvc.thread.chapter1.interrupt.test2;

/**
 * Created by dujiayong on 2019/2/23.
 */
public class Run2 {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止 1 ?=" + Thread.interrupted());
        System.out.println("是否停止 2 ?=" + Thread.interrupted());
        System.out.println("end!!!");
    }
}
