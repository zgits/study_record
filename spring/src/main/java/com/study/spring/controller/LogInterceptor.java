package com.study.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class LogInterceptor implements Interceptor {


    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间
        logger.info("Interceptor22222"+String.format("发送请求 %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应的时间
        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        printLog("接受响应", responseBody.string());
        return response;
    }


    public static void printLog(String tag, String msg) {
        logger.info(msg);
        //此处也可以画分割线
        //log.e(tag,"----------------------------------------------")
//        for (String line : lines) {
//            Log.d(tag, "|" + line);
//        }
        //log.e(tag,"----------------------------------------------")



    }
}
