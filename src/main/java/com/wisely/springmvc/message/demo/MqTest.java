package com.wisely.springmvc.message.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by dujiayong on 2020/3/7.
 */
public class MqTest {

    public static void main(String[] args) {
        try {
//            String message = "rabbitmq-测试";
//            for (int i = 0; i < 10; i++) {
//                MqProducer.send(message + (i + 1));
//            }

            // 消息模式:Push 推模式 Deliver模式
//            MqConsumer.batchConsume();

            // 消息模式:Pull 拉模式
            MqConsumer.get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
