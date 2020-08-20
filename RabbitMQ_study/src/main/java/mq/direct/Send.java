package mq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {


    protected static final String EXCHANGE_NAME = "directExchange";

    protected static final String QUEUE_NAME = "directQueue";

    protected static final String ROUTE_KEY1 = "directRoutekey.add";
    protected static final String ROUTE_KEY2 = "directRoutekey.delete";



    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        // 交换机声明
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, null);

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY1);

        channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY2, MessageProperties.PERSISTENT_TEXT_PLAIN, "direct_message_delete".getBytes());

        System.out.println("发送消息");

        channel.close();
        connection.close();

    }
}
