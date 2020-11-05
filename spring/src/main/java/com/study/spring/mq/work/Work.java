package com.study.spring.mq.work;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Work {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    void message1(String message) {
        System.out.println("message1 = " + message);
    }



    @RabbitListener(queuesToDeclare = @Queue("work"))
    void message2(String message) {
        System.out.println("message2 = " + message);
    }
}
