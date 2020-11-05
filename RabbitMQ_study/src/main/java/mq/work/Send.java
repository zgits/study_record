package mq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static void main(String[] args) throws IOException, TimeoutException {
        /**
         * 创建连接到RabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();

        // 设置RabbitMQ所在主机的IP或者主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个频道
        Channel channel = connection.createChannel();
        // 指定一个行列
        channel.queueDeclare("workQueue",true,false,false,null);
        // 发送的消息
        String message = "hello world!";
        // 往队列中发送一条消息

        for (int i = 0; i < 11; i++) {
            System.out.println("Send "+ message);
            channel.basicPublish("", "workQueue", null, (i + message).getBytes());
        }

        channel.close();
        connection.close();
    }
}
