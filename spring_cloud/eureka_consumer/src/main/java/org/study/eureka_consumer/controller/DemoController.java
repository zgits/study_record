package org.study.eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @date 2021年06月22日 23:04
 * @description
 */

@RestController
public class DemoController {


    @Autowired
    RestTemplate restTemplate;

    @Value("${eurekas.producername}")
    String procudur;

    @RequestMapping("greet")
    public String sayHello(){
        return restTemplate.getForObject("http://" + procudur + "/sayHello", String.class);
    }
}
