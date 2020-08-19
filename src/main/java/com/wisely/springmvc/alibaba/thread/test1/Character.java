package com.wisely.springmvc.alibaba.thread.test1;

/**
 * Created by dujiayong on 2018/6/28
 */
public class Character implements Runnable {

    Test1Resource test1Resource;
    private int threadId;
    private char character = 'A';

    public Character(Test1Resource resource,int threadId){
        this.test1Resource = resource;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        synchronized (test1Resource){
            while (true){
                if(!test1Resource.flag){
                    if(character <= 'Z'){
                        System.out.println("thread" + threadId + ":" + character);
                    }else{
                        try {
                            test1Resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    character+=1;
                    test1Resource.flag = true;
                    test1Resource.notifyAll();
                }else{
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
