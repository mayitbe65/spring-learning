package com.spring.event.controller;

import com.spring.event.bean.MsgTemplate;
import com.spring.event.service.SendMsgEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class SendController {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping("/send")
    public String send(MsgTemplate msgTemplate) {
        System.out.println("msgTemplate: " + msgTemplate);
        applicationEventPublisher.publishEvent(new SendMsgEvent(msgTemplate));
        return "ok";
    }
}
