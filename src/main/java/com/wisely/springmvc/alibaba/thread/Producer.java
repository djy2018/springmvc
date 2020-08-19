package com.wisely.springmvc.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class Producer implements Runnable{

    private QueueBuffer q;

    public Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
