package com.wisely.springmvc.alibaba.thread;

/**
 * Created by dujiayong on 2018/6/27
 */
public class ThreadResource {

    private boolean flag = true;
    private int n = 1;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
