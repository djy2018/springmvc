package com.wisely.springmvc.alibaba.thread.test2;

/**
 * Created by dujiayong on 2018/6/29
 */
public class Test2 {

    public static void main(String[] args) {
        new Thread(new MyThread(1,'A')).start();
        new Thread(new MyThread(2,'B')).start();
        new Thread(new MyThread(3,'C')).start();
    }
}

class MyThread implements Runnable {
    private int threadId;
    private char character;
    private static int i = 0;

    public MyThread(int threadId, char character) {
        this.threadId = threadId;
        this.character = character;
    }

    @Override
    public void run() {
        while (i < 30){
            synchronized (Test2.class) {
                if ((i % 3 + 1) == threadId) {
                    System.out.println("thread" + threadId + ":" + character);
                    i++;
                    Test2.class.notifyAll();
                } else {
                    try {
                        Test2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
