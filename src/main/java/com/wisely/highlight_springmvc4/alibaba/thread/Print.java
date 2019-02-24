package com.wisely.highlight_springmvc4.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class Print {

    public static void main(String[] args) {
        new Thread(new PrintRunnable(1)).start();
        new Thread(new PrintRunnable(2)).start();
//        new Thread(new PrintRunnable(3)).start();
    }
}

class PrintRunnable implements Runnable {

    private static volatile int printNum = 1;
    private static volatile char character = 'A';
    private int threadId;

    public PrintRunnable(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (printNum < 72) {
            synchronized (Print.class) {
                if (printNum%3 == (2-threadId)) {
                    System.out.println("线程" + threadId + ":" + character);
                    character++;
                    for (int i = 0; i < 1; i++) {
                        System.out.println("线程" + threadId + ":" + (++printNum));
                    }
                    Print.class.notifyAll();
                } else {
                    try {
                        Print.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
