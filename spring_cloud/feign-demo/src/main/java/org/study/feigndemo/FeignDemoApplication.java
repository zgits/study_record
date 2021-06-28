package org.study.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.feigndemo.client.RemoteClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.study.feigndemo.client")
@RestController
public class FeignDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class, args);
    }


    @Autowired
    private RemoteClient userRemoteClient;



    @GetMapping("/callHello")
    public String callHello() {
        //return restTemplate.getForObject("http://localhost:8083/house/hello",String.class);
        //String result = restTemplate.getForObject("http://eureka-client-user-service/user/hello",String.class);
        String result = userRemoteClient.sayHello();
        System.out.println("调用结果：" + result);
        return result;
    }

}
