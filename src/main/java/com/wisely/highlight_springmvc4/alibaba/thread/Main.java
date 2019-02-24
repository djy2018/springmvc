package com.wisely.highlight_springmvc4.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class Main {

    public static void main(String[] args) {
        QueueBuffer q = new QueueBuffer();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }

}
