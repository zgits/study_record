package mq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {


    private static final String EXCHANGE_NAME = "fanoutExchangeName";

    public static final String QUEUE_NAME = "fanoutQueueName";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message = "fanout消息";

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());


        System.out.println("成功发送消息");

        channel.close();
        connection.close();
    }
}
