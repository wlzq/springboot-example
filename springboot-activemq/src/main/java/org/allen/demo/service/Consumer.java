package org.allen.demo.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @JmsListener(destination = "jms.msg.queue")
    public void receiveMessage(String text){
        System.out.println("接收消息时间："+System.currentTimeMillis()+", 接收到消息:"+text);
    }

    @JmsListener(destination = "jms.msg.topic")
    public void receiveTopicMessage1(String text){
        System.out.println("消费者1接收消息时间："+System.currentTimeMillis()+", 接收到消息:"+text);
    }

    @JmsListener(destination = "jms.msg.topic")
    public void receiveTopicMessage2(String text){
        System.out.println("消费者2接收消息时间："+System.currentTimeMillis()+", 接收到消息:"+text);
    }

}
