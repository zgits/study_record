package com.study.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OkHttp {


    private static final Logger logger = LoggerFactory.getLogger(OkHttp.class);




    public static void test(){
        logger.trace("这是trace日志");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        /**
         * 运行后,从info信息开始输出,说明Springboot默认是info级别的日志信息
         */
        logger.warn("这是warning信息");
        logger.error("这是error信息");
    }

    public static void main(String[] args) throws IOException {



//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String s) {
//                try {
//                    String text = URLDecoder.decode(s, "utf-8");
//                    logger.info("OKHttp-----", text);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                    logger.info("OKHttp-----", s);
//                }
//            }
//        });
//
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor()).build();
//
//        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8080/api/model")
//                .build();
//
//        Response response = okHttpClient.newCall(request).execute();
        /**
         * 日志级别,由低到高
         * 我们可以调整日志级别,日志就只会在这个级别以后生效
         */
        logger.trace("这是trace日志");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        /**
         * 运行后,从info信息开始输出,说明Springboot默认是info级别的日志信息
         */
        logger.warn("这是warning信息");
        logger.error("这是error信息");
    }
}
