package mq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class recv1 {


    private static final String EXCHANGE_NAME = "topicExchangeName";

    public static final String QUEUE_NAME = "topicQueueName1";

    public static final String ROUTE_KEY1 = "topickey.add";

    public static final String ROUTE_KEY2 = "topickey.delete";

    public static final String ROUTE_KEY3 = "topickey.update";


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setVirtualHost("/study");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME, "topickey.*");

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息"+new String(body));
            }
        };
        channel.basicConsume(QUEUE_NAME,true, consumer);


    }
}
