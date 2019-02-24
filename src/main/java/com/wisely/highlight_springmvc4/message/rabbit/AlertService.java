package com.wisely.highlight_springmvc4.message.rabbit;

import java.util.Map;

/**
 * Created by dujiayong on 2018/11/29
 */
public interface AlertService {

    void sendSpittleAlert(Spittle spittle);

    void sendSpittleAlert(Map<String,Spittle> map);

    Spittle receiveSpittleAlert();

}
