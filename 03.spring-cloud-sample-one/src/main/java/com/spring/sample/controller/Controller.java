package com.spring.sample.controller;

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

    @GetMapping
    public String hello() {
        return "hello one";
    }
}
