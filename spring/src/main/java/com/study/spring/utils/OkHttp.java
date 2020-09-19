package com.study.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OkHttp {


    private final static Logger logger = LoggerFactory.getLogger(OkHttp.class);

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
    }
}
