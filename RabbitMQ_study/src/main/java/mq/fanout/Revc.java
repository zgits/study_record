package mq.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

public class Revc {


    private static final String EXCHANGE_NAME = "fanoutExchangeName";

    public static final String QUEUE_NAME = "fanoutQueueName";


    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        //同一时刻服务器只会发送一条消息给消费者
//        channel.basicQos(1);

        //定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消息内容" + new String(body, "UTF-8"));
            }
        };

        channel.basicConsume(QUEUE_NAME,consumer);

    }
}
