package com.javastudy.controller;

import com.javastudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/message/listen")
    public void createMsg(@RequestParam String msg){
        this.jmsTemplate.convertAndSend("customer:msg:new",msg);
    }
    @PostMapping("/message/direct")
    public void handle(@RequestParam String msg){
        this.customerService.handleMsg(msg);
    }
    @GetMapping("/message")
    public String getMessage(){
        Object obj = this.jmsTemplate.receiveAndConvert("customer:msg:reply");
        return String.valueOf(obj);
    }
}
