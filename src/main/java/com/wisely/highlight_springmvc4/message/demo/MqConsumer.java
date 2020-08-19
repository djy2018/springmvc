package com.wisely.highlight_springmvc4.message.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by dujiayong on 2020/3/7.
 */
public class MqConsumer {

    /**
     * 消息订阅 : 推模式 Push
     * prefetchCount:Push模式下 Rabbit服务端推送给客户端未被确认数量限制，
     * 客户端未被确认消息超过这个数量，服务端不再向客户端推送消息，直至客户端对之前发送消息进行消息确认.
     * 优点:可以实现高吞吐量
     *
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public static void batchConsume() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("access_dev");
        factory.setPassword("Netease163#Access");
        factory.setHost("10.246.103.31");
        factory.setPort(5672);
        factory.setVirtualHost("/access");
        Connection connection = factory.newConnection("MQConsumer-test");
        Channel channel = connection.createChannel();
        channel.basicQos(50);
        channel.basicConsume("test-queue", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();

                long deliveryTag = envelope.getDeliveryTag();

                // 业务逻辑处理
                System.out.println("消费者-basicConsume: 时间 -> " + System.currentTimeMillis() + " 接收消息 -> " + new String(body));

                channel.basicAck(deliveryTag, true);
            }
        });
        Thread.sleep(10000);
        channel.close();
        connection.close();
    }

    /**
     * 从队列中获取单条消息 : 拉模式 Pull
     *
     * @throws IOException
     * @throws TimeoutException
     */
    public static void get() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("access_dev");
        factory.setPassword("Netease163#Access");
        factory.setHost("10.246.103.31");
        factory.setPort(5672);
        factory.setVirtualHost("/access");
        Connection connection = factory.newConnection("MQConsumer-test");
        Channel channel = connection.createChannel();
        GetResponse response = channel.basicGet("test-queue", false);
        System.out.println("消费者-basicGet: 时间 -> " + System.currentTimeMillis() + " 接收消息 -> " + new String(response.getBody()));
        channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
        channel.close();
        connection.close();
    }

}
