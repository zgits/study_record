package org.study.hystrixfeigndemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @date 2021年06月29日 22:59
 * @description
 */
@RestController
public class DemoController {


    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello")
    public String callHello() {
        String result = restTemplate.getForObject("http://localhost:8088/house/hello", String.class);
        return result;
    }


    public String defaultCallHello() {
        return "fail";
    }
}
