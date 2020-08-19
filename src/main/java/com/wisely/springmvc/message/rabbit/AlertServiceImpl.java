package com.wisely.springmvc.message.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author dujiayong
 * @date 2018/11/29
 **/
@Service
public class AlertServiceImpl implements AlertService {

    private static Logger logger = LoggerFactory.getLogger(AlertServiceImpl.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
//        rabbitTemplate.convertAndSend("spittle.fanout","spittle.alerts",spittle);
        rabbitTemplate.convertAndSend(spittle);
//        rabbitTemplate.convertAndSend("spittle.topic","spittle.alert.queue",spittle);
//        rabbitTemplate.convertAndSend("spittle.topic","lazy.alert.queue",spittle);
    }

    @Override
    public void sendSpittleAlert(Map<String,Spittle> map) {
//        rabbitTemplate.convertAndSend("spittle.fanout","spittle.alerts",spittle);
        rabbitTemplate.convertAndSend(map);
//        rabbitTemplate.convertAndSend("spittle.topic","spittle.alert.queue",spittle);
//        rabbitTemplate.convertAndSend("spittle.topic","lazy.alert.queue",map);
    }

    @Override
    public Spittle receiveSpittleAlert() {
//        Spittle spittle = (Spittle) rabbitTemplate.receiveAndConvert("spittle.alert.queue.1");
//        Spittle spittle2 = (Spittle) rabbitTemplate.receiveAndConvert("spittle.alert.queue.2");
        Spittle spittle3 = (Spittle) rabbitTemplate.receiveAndConvert("spittle.alert.queue.3");
//
//        Spittle spittle4 = (Spittle) rabbitTemplate.receiveAndConvert("lazy.alert.queue.1");
//        Spittle spittle5 = (Spittle) rabbitTemplate.receiveAndConvert("lazy.alert.queue.2");

//        Spittle spittle = (Spittle)rabbitTemplate.receiveAndConvert("spittle.alerts");
        Map<String,Spittle> map = (Map<String,Spittle>)rabbitTemplate.receiveAndConvert("spittle.alerts");
        return map.get("object");
    }

}
