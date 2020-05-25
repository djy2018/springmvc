package com.wisely.springmvc.message.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
public class SpittleAlertHandler implements MessageListener{

    private static Logger logger = LoggerFactory.getLogger(SpittleAlertHandler.class);

    public void handleSpittleAlert(String string) {
        logger.info("监听队列，消费消息");
        logger.info("receive object is : {}",string);
    }

    @Override
    public void onMessage(Message message) {
        logger.info("监听队列，消费消息");
        TextMessage text = (TextMessage) message;
        try {
            Spittle spittle = new ObjectMapper().readValue(text.getText(),Spittle.class);
            logger.info("receive object is : {}",spittle.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
