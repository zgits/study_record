package mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {

    private static final String QUEUE_NAME = "helloMQ";

    public static void main(String[] args) throws IOException, TimeoutException {

        // 打开连接和创建频道一样，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String temp = BuiltinExchangeType.DIRECT.getType();

        channel.queueDeclare(QUEUE_NAME,false, false, false, null);
        System.out.println("wait");


        //创建消费者
        Consumer consumer = new DefaultConsumer(channel) {

            
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("receive"+message);
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);


    }
}
