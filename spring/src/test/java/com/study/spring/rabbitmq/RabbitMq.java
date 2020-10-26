package com.study.spring.rabbitmq;

import com.study.spring.ApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMq extends ApplicationTests {


    @Autowired
    RabbitTemplate rabbitTemplate;



    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello", "spring mq");
    }



    @Test
    public void testWord(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "spring mq" + i);
        }
    }



    @Test
    public void fanoutTest(){
        rabbitTemplate.convertAndSend("logs","","spring fanout");
    }



    @Test
    public void directTest(){
        rabbitTemplate.convertAndSend("direct","inf1o","spring direct");
    }


    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend("topic","user.save","spring topic");
        rabbitTemplate.convertAndSend("topic","user.save.test","spring topic");
    }
}
