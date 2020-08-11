package mq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {


    protected static final String EXCHANGE_NAME = "directExchange";

    protected static final String QUEUE_NAME = "directQueue";

    protected static final String ROUTE_KEY = "directRoutekey";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        // 交换机声明
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, null);

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,"direct_message".getBytes());


        connection.close();

        channel.close();
    }
}
