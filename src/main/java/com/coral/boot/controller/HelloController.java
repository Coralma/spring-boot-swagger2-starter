package com.coral.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ccc on 2018/5/2.
 */
@Api(value = "HelloController", description = "Hello World接口")
@RestController
public class HelloController {

    @ApiOperation("Swagger Hello接口")
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    @ResponseBody
    String hello() {
        return "Hello World";
    }

}
