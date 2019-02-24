package com.wisely.highlight_springmvc4.message.jms;

/**
 * Created by dujiayong on 2018/11/29
 */
public interface AlertService {

    void sendSpittleAlert(Spittle spittle);

    Spittle receiveSpittleAlert();

}
