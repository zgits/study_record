package mq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {


    private static final String QUEUE_NAME = "test_queue_word";

    public static void main(String[] args) throws IOException, TimeoutException {





        // 获取到连接以及mq通道
        ConnectionFactory factory = new ConnectionFactory();


        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        // 定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel);

        // 监听队列，false表示手动返回状态，true表示自动
        channel.basicConsume(QUEUE_NAME,true,defaultConsumer);

        while (true) {

        }

    }
}
