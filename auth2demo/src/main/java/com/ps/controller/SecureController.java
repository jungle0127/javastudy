package com.ps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SecureController {
    @GetMapping("/test")
    public String test(){
        return "TEST";
    }
    @GetMapping("/secure")
    public String check(){
        return "secure";
    }
}
