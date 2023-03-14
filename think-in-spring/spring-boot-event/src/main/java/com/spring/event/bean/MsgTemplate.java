package com.spring.event.bean;


import lombok.Data;

@Data
public class MsgTemplate {

    // 消息发送类型 0:mail 1:短信
    private Integer msgType;
    private String content;
}
