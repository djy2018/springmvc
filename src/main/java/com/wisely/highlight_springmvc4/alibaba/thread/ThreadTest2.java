package com.wisely.highlight_springmvc4.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class ThreadTest2 {

    public void test() {
        ThreadResource resource = new ThreadResource();
        new Thread1(resource);
        new Thread2(resource);
        new Thread3(resource);
    }

    public static void main(String[] args) {
        ThreadTest2 test = new ThreadTest2();
        test.test();
    }


    class Thread1 implements Runnable {

        ThreadResource resource;
        Thread thread;

        public Thread1(ThreadResource resource) {
            this.resource = resource;
            thread = new Thread(this, "thread1");
            thread.start();
        }

        @Override
        public void run() {
            for (int i = 1; i < 76; i++) {
                synchronized (resource) {
                    if (resource.getN() == 1) {
                        if ((i - 1) / 5 % 3 == 0) {
                            System.out.println(thread.getName() + ":" + i);
                        }else{
                            i+=7;
                            resource.setN(2);
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

    class Thread2 implements Runnable {

        ThreadResource resource;
        Thread thread;

        public Thread2(ThreadResource resource) {
            this.resource = resource;
            thread = new Thread(this, "thread2");
            thread.start();
        }

        @Override
        public void run() {
            synchronized (resource) {
                for (int i = 6; i < 76; i++) {
                    if (resource.getN() == 2) {
                        if ((i - 1) / 5 % 3 == 1) {
                            System.out.println(thread.getName() + ":" + i);
                        }else{
                            i+=7;
                            resource.setN(3);
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

    class Thread3 implements Runnable {

        ThreadResource resource;
        Thread thread;

        public Thread3(ThreadResource resource) {
            this.resource = resource;
            thread = new Thread(this, "thread3");
            thread.start();
        }

        @Override
        public void run() {
            synchronized (resource) {
                for (int i = 11; i < 76; i++) {
                    if (resource.getN() == 3) {
                        if ((i - 1) / 5 % 3 == 2) {
                            System.out.println(thread.getName() + ":" + i);
                        }else{
                            i+=7;
                            resource.setN(1);
                            resource.notifyAll();
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
