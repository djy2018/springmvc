package com.wisely.highlight_springmvc4.message.jms;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.IOException;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
public class AlertServiceImpl implements AlertService {

    private static Logger logger = LoggerFactory.getLogger(AlertServiceImpl.class);

    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendSpittleAlert(final Spittle spittle) {
        jmsOperations.convertAndSend(spittle);
    }

    @Override
    public Spittle receiveSpittleAlert() {
        try {
            TextMessage textMessage = (TextMessage) jmsOperations.receive();
            return new ObjectMapper().readValue(textMessage.getText(),Spittle.class);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
