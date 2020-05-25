package com.wisely.springmvc;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
@Configuration
@ImportResource("classpath:jmsConfig.xml")
public class ActivemqConfig {

    /**
     * ActiveMQConnectionFactory是ActiveMQ自带的连接工厂，可以使消息发送者连接ActiveMQ消息代理
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public ActiveMQQueue queue(){
        ActiveMQQueue queue = new ActiveMQQueue();
        queue.setPhysicalName("spittle.alert.queue");
        return queue;
    }

    @Bean
    public ActiveMQTopic topic(){
        ActiveMQTopic topic = new ActiveMQTopic();
        topic.setPhysicalName("spittle.alert.topic");
        return topic;
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        return messageConverter;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName("spittle.alert.queue");
        jmsTemplate.setMessageConverter(messageConverter());
        return jmsTemplate;
    }

}
