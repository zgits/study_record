package com.study.spring.controller;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import okhttp3.*;
import okio.BufferedSink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@Api(value = "ApiController")
public class ApiController {


    @GetMapping("/model")
    @ApiOperation(value="一个测试API",notes = "第一个测试api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataTypeClass = ArrayList.class)
    })
    public  String  apiModelMethod() throws IOException {




        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor()).build();


        Request request = new Request.Builder()
                .url("http://59.110.233.117:8091/service/postDeptPolicyMessageInfo")
                .post(new RequestBody() {
                    @Nullable
                    @Override
                    public MediaType contentType() {
                        return null;
                    }

                    @Override
                    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {

                    }
                })
                .build();

        Response response = okHttpClient.newCall(request).execute();


        return "ApiInfo";
    }

}
