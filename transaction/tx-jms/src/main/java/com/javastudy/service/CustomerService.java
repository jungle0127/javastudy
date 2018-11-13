package com.javastudy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JmsTemplate jmsTemplate;
    @JmsListener(destination = "customer:msg:new")
    public void handleMsg(String msg){
        logger.info("get message:{}",msg);
        String reply = "reply-" + msg;
        this.jmsTemplate.convertAndSend("customer:msg:reply",reply);
        if(msg.contains("error")){
            this.simulateException();
        }
    }

    private void simulateException(){
        throw new RuntimeException("pseudo exception.");
    }
}
