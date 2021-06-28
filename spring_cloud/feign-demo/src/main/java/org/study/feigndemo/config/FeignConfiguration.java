package org.study.feigndemo.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2021年06月26日 13:56
 * @description
 */
@Configuration
public class FeignConfiguration {


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @Order(2)
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }

    @Bean
    @Order(1)
    public FeignBasicAuthRequestInterceptor2 basicAuthRequestInterceptor2(){
        return new FeignBasicAuthRequestInterceptor2();
    }



    @Bean
    public Request.Options options() {
        return new Request.Options(5000, TimeUnit.MILLISECONDS, 10000, TimeUnit.MILLISECONDS, true);
    }


    class FeignBasicAuthRequestInterceptor implements RequestInterceptor {



        public FeignBasicAuthRequestInterceptor() {
        }
        @Override
        public void apply(RequestTemplate template) {

//            template.header("Content_TYPE_H")
            System.out.println("调用");

            System.out.println(template.toString());
        }

    }


    class FeignBasicAuthRequestInterceptor2 implements RequestInterceptor {



        public FeignBasicAuthRequestInterceptor2() {
        }
        @Override
        public void apply(RequestTemplate template) {

//            template.header("Content_TYPE_H")
            System.out.println("调用2");
            System.out.println(template.toString());
            template.query("param", FeignBasicAuthRequestInterceptor2.class.getSimpleName());
        }

    }


}
