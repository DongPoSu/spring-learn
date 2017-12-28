package com.walkbear.spring.learn.web.controller;

import com.walkbear.spring.learn.common.utils.DateUtils;
import com.walkbear.spring.learn.persistence.support.AppConfig;
import com.walkbear.spring.learn.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: suzheng
 * version: v.1.0
 * package: com.walkbear.spring.learn.web.controller
 * company: SiBu
 * create_date: 2017/12/19
 * description :
 * @author suzheng
 */
@Slf4j
@RestController
@RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping(value = "/get")
    public String get(){
        testService.print();
        log.info("the method name's get be invoked");
        log.info("打印imagePath[{}]", AppConfig.getInstance().getImagePath("/ttttttttttttt"));
        return DateUtils.getDayBegin().toString();
    }
}

