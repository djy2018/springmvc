package com.wisely.springmvc.message.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by dujiayong on 2020/3/7.
 */
public class MqProducer {

    public static void send(String message) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("access_dev");
        factory.setPassword("Netease163#Access");
        factory.setHost("10.246.103.31");
        factory.setPort(5672);
        factory.setVirtualHost("/access");
        Connection connection = factory.newConnection("MQProducer-test");
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test-exchange", "direct", false, false, null);
        channel.queueDeclare("test-queue", false, false, false, null);
        channel.queueBind("test-queue", "test-exchange", "rk.test");
        System.out.println("消息发送 is starting");
        channel.basicPublish("test-exchange", "rk.test", null, message.getBytes());
        System.out.println("消息发送 is succeed");
        channel.close();
        connection.close();
    }
}
