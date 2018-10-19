package org.allen.demo.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Produce implements MessageDao {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String dest, String msg) {
        int i=0;
        while(i<10){
            System.out.println("发送消息时间："+System.currentTimeMillis());
            i++;
            jmsMessagingTemplate.convertAndSend(dest, msg+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendTopicMessage(String dest, String msg) {
        for(int i=0;i<0;i++){
            try {
                System.out.println("发送消息，时间："+System.currentTimeMillis());
                jmsMessagingTemplate.convertAndSend(dest, msg);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
