package org.study.feigndemo.client;


import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.study.feigndemo.config.FeignConfiguration;

@FeignClient(value = "EUREKA-PRODUCER",configuration = FeignConfiguration.class)
public interface RemoteClient {


    @GetMapping("sayHello")
    String sayHello();

}
