/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * @author flysLi
 * @ClassName RabbitMqConsumer
 * @Decription TODO
 * @Date 2019/1/24 15:10
 * @Version 1.0
 */
public class RabbitMqConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(RabbitMqProductor.QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] bytes) throws UnsupportedEncodingException {
                String message = new String(bytes, "UTF-8");
                System.out.println("消息受理:" + message);
            }
        };

        /*自动回复队列应答(rabbitMQ中的消息确认机制)*/
        channel.basicConsume(RabbitMqProductor.QUEUE_NAME, true, consumer);
//        channel.close();
//        connection.close();
    }
}
