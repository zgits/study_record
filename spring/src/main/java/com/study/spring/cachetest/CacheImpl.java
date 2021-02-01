package com.study.spring.cachetest;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "cacheTest")
public class CacheImpl {



    @Cacheable
    public String testCache(){

        System.out.println("doing");

        return "done";
    }




}
