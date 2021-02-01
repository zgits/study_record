package com.study.spring.cacheTest;

import com.study.spring.ApplicationTests;
import com.study.spring.cachetest.CacheImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

public class CacheTest extends ApplicationTests {


    @Autowired
    private CacheImpl cache;


    @Autowired
    private CacheManager cacheManager;




    @Test
    public void testCache(){

        System.out.println(cacheManager.getClass());


        System.out.println("1:" + cache.testCache());;
        System.out.println("2:" + cache.testCache());;



    }
}
