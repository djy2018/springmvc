package com.wisely.springmvc.message.jms;

import java.io.Serializable;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
public class Spittle implements Serializable {

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
