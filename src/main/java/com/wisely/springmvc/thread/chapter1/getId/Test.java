package com.wisely.springmvc.thread.chapter1.getId;

/**
 * getId()方法：获取线程的唯一标识
 * Created by dujiayong on 2019/2/23.
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ":" + thread.getId());
    }
}
