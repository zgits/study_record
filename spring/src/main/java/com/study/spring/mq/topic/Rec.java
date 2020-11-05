package com.study.spring.mq.topic;


import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component("topicRec")
public class Rec {


    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topic", type = "topic"),
            key = {"user.save","user.*"}
    )
    )
    public void message(String message) {
        System.out.println("message = " + message);
    }



    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topic", type = "topic"),
            key = {"user.#","user.*"}
    )
    )
    public void message1(String message) {
        System.out.println("message2 = " + message);
    }
}
