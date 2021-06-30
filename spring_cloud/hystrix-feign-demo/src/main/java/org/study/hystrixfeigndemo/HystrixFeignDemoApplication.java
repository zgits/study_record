package org.study.hystrixfeigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixFeignDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignDemoApplication.class, args);
    }



    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
