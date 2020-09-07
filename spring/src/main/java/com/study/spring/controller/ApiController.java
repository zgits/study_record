package com.study.spring.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public  String  apiModelMethod(){
        return "ApiInfo";
    }

}
