package com.walkbear.spring.learn.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2017-08-23
 * Description:
 */
@Slf4j
@Service("testService")
public class TestServiceImpl implements TestService{
    @Override
    public void print() {
        log.error("TestServiceImpl print method be invoked");
    }
}
