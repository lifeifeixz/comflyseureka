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

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author flysLi
 * @ClassName RabbitMqProductor
 * @Decription TODO
 * @Date 2019/1/24 14:58
 * @Version 1.0
 */
@SuppressWarnings("all")
public class RabbitMqProductor {

    public final static String QUEUE_NAME = "rabbitMQ_flysLi";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        //创建一个链接
        final Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送消息到队列
        String message = "Hello RabbitMQ";
        for (int i = 0; i < 10000; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}

@SuppressWarnings("ALL")
class MqTopic {
    public final static String QUEUE_NAME = "directQueue_flys";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        String exChange = "directExchange";
        String routingKey = "directMessage";
        //创建一个链接
        final Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exChange, "direct");
        //声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定队列到交换机
        channel.queueBind(QUEUE_NAME,exChange,routingKey);
        //发送消息到队列
        String message = "Hello DirectMQ";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish(exChange, routingKey, null, (message + i).getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
