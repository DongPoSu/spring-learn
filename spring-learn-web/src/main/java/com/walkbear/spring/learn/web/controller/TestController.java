package com.walkbear.spring.learn.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: suzheng
 * version: v.1.0
 * package: com.walkbear.spring.learn.web.controller
 * company: SiBu
 * create_date: 2017/12/19
 * description :
 * @author suzheng
 */
@RestController
@RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    @RequestMapping(value = "/get")
    public String get(){
        return "get";
    }
}
