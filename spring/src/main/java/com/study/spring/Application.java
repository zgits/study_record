package com.study.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.PrintStream;


/**
 *
 * @see com.study.spring.Application
 */

@SpringBootApplication
@ComponentScan(nameGenerator = AnnotationBeanNameGenerator.class)
public class Application {

    public static void main(String[] args) {


        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));

        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
//
//        SpringApplication.run(Application.class, args);
    }

}
