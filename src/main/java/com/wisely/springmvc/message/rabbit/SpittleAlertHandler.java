package com.wisely.springmvc.message.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
public class SpittleAlertHandler {

    private static Logger logger = LoggerFactory.getLogger(SpittleAlertHandler.class);

    public void handleSpittleAlert(Map<String,Spittle> map) {
        logger.info("监听队列，消费消息");
        logger.info("receive object is : {}",map.get("object").toString());
    }

}
