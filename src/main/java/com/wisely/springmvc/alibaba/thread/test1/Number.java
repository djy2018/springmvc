package com.wisely.springmvc.alibaba.thread.test1;

/**
 * Created by dujiayong on 2018/6/28
 */
public class Number implements Runnable {

    Test1Resource test1Resource;
    private int threadId;

    public Number(Test1Resource resource, int threadId) {
        this.test1Resource = resource;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        synchronized (test1Resource) {
            for (int i = 1; i <= 52; i++) {
                if (i % 2 == 1) {
                    if(test1Resource.flag){
                        System.out.println("thread" + threadId + ":" + i);
                        System.out.println("thread" + threadId + ":" + (i + 1));
                        test1Resource.flag = false;
                        test1Resource.notifyAll();
                    }
                } else {
                    try {
                        test1Resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
