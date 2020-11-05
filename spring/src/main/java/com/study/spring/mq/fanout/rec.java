package com.study.spring.mq.fanout;


import com.rabbitmq.client.BuiltinExchangeType;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component("fanoutRec")
public class rec {


    @RabbitListener(bindings =
            @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "logs",type = "fanout"))
    )
    public void message1(String message) {
        System.out.println("message1 = " + message);
    }



    @RabbitListener(bindings =
    @QueueBinding(value = @Queue,  //创建临时队列
            exchange = @Exchange(value = "logs",type = "fanout"))
    )
    public void message2(String message) {
        System.out.println("message2 = " + message);
    }
}
