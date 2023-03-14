package com.spring.event.service;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class SendMsgListener {


    @EventListener(condition = "#sendMsgEvent.msgTemplate.msgType == 0")
    public void sendMail(SendMsgEvent sendMsgEvent) {
        System.out.println("sendMail: " + sendMsgEvent.getMsgTemplate().getContent());
    }

    @EventListener(condition = "#sendMsgEvent.msgTemplate.msgType == 1")
    public void sendSms(SendMsgEvent sendMsgEvent) {
        System.out.println("sendSms: " + sendMsgEvent.getMsgTemplate().getContent());
    }

    @EventListener
    public void send(SendMsgEvent sendMsgEvent) {
        System.out.println("send: " + sendMsgEvent);
    }
}
