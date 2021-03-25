package com.spring.sample.controller;

import com.spring.sample.service.SampleTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yu.zhang
 * created on 2021/03/22
 */
@RestController
@RequestMapping("/one")
public class Controller {

    @Autowired
    private SampleTwoService sampleTwoService;


    @GetMapping
    public String hello() {
        return "hello one";
    }

    @GetMapping("call2")
    public String callTwo() {
        return sampleTwoService.sayHello();
    }
}
