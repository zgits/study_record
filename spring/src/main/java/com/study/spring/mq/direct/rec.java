package com.study.spring.mq.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component("directRec")
public class rec {


    @RabbitListener(bindings =
        @QueueBinding(
                value = @Queue,
                exchange = @Exchange(name = "direct",type = "direct"),
                key="info"
        )
    )
    public void message1(String message) {
        System.out.println("message1 = " + message);
    }
}
