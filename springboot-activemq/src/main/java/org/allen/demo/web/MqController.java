package org.allen.demo.web;

import org.allen.demo.service.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private Produce produce;

    @GetMapping
    public String send(){
        String msg = "发送消息。。。";
        //String dest = "jms.msg.queue";//队列
        String dest = "jms.msg.topic";//订阅
        produce.sendMessage(dest, msg);
        return "success";
    }

}
