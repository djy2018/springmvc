package com.wisely.highlight_springmvc4.thread.chapter1.test5;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class ThreadB extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("b","bbbb");
    }

}
