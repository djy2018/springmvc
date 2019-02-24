package com.wisely.highlight_springmvc4.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class Consumer implements Runnable{

    private QueueBuffer q;

    public Consumer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}
