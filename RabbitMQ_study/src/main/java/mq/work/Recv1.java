package mq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {


    private static final String QUEUE_NAME = "test_queue_word";

    public static void main(String[] args) throws IOException, TimeoutException {





        // 获取到连接以及mq通道
        ConnectionFactory factory = new ConnectionFactory();


        Connection connection = factory.newConnection();


        final Channel channel = connection.createChannel();


        // 声明队列
        channel.queueDeclare("workQueue", true, false, false, null);


        // 定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1:"+new String(body));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicQos(1);

        // 监听队列，false表示手动返回状态，true表示自动
        channel.basicConsume("workQueue", false, defaultConsumer);


    }
}
