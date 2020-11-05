package mq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {

    protected static final String EXCHANGE_NAME = "directExchange";

    protected static final String QUEUE_NAME = "directQueue2";

    protected static final String ROUTE_KEY = "directRoutekey.add";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setVirtualHost("/study");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);


        //声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //队列与交换机绑定(参数为：队列名称；交换机名称；密钥-routeKey)
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY);


        DefaultConsumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("direct模式接收的消息"+message);
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);


    }
}
