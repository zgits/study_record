package mq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {


    private static final String QUEUE_NAME = "test_queue_word";

    public static void main(String[] args) throws IOException, TimeoutException {





        // 获取到连接以及mq通道
        ConnectionFactory factory = new ConnectionFactory();


        Connection connection = factory.newConnection();


        final Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare("workQueue", true, false, false, null);
        channel.basicQos(1);

        // 定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2:"+new String(body));

                // 参数2 是否开启多消息确认
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // 监听队列，false表示手动返回状态，true表示自动
        channel.basicConsume("workQueue", false, defaultConsumer);


    }
}
