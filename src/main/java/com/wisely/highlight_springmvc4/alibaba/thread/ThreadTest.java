package com.wisely.highlight_springmvc4.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class ThreadTest {

    public void test() {
        ThreadResource resource = new ThreadResource();
        new OddThread(resource);
        new EvenThread(resource);
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.test();
    }


    class OddThread implements Runnable {

        ThreadResource resource;
        Thread thread;

        public OddThread(ThreadResource resource) {
            this.resource = resource;
            thread = new Thread(this,"odd");
            thread.start();
        }

        @Override
        public void run() {
            for (int i = 1; i < 101; i++) {
                synchronized (resource) {
                    if (resource.isFlag()) {
                        if (i % 2 != 0) {
                            System.out.println(thread.getName() + ":" + i);
                            resource.setFlag(false);
                            resource.notify();
                        }
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class EvenThread implements Runnable {

        ThreadResource resource;
        Thread thread;

        public EvenThread(ThreadResource resource) {
            this.resource = resource;
            thread = new Thread(this,"even");
            thread.start();
        }

        @Override
        public void run() {
            synchronized (resource) {
                for (int i = 2; i < 101; i++) {
                    if (!resource.isFlag()) {
                        if (i % 2 == 0) {
                            System.out.println(thread.getName() + ":" + i);
                            resource.setFlag(true);
                            resource.notify();
                        }
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
