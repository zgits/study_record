package mq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class send {

    private static final String EXCHANGE_NAME = "topicExchangeName";

    public static final String QUEUE_NAME = "topicQueueName";

    public static final String ROUTE_KEY1 = "topickey.add";

    public static final String ROUTE_KEY2 = "topickey.delete";

    public static final String ROUTE_KEY3 = "topickey.update";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false,false, null);


        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String message1 = "add message";
        String message2 = "delete message";
        String message3 = "update message";

        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY1,null,message1.getBytes());

        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY2,null,message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY3,null,message3.getBytes());
        channel.basicPublish(EXCHANGE_NAME,"topickey.test",null,"test".getBytes());

        channel.close();
        connection.close();

    }
}
