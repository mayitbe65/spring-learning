package com.spring.event.service;


import com.spring.event.bean.MsgTemplate;
import org.springframework.context.ApplicationEvent;


public class SendMsgEvent extends ApplicationEvent {

    public SendMsgEvent(MsgTemplate template) {
        super(template);
    }

    public MsgTemplate getMsgTemplate() {
        return (MsgTemplate) getSource();
    }
}
