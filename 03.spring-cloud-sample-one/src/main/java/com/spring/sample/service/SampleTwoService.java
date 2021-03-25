package com.spring.sample.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yu.zhang
 * created on 2021/03/24
 */
@FeignClient("spring-cloud-sample-two")
public interface SampleTwoService {

    @GetMapping("/two")
    String sayHello();
}
