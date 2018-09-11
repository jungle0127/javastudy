package com.ps.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.interceptor.cache.CertificateCache;

@RestController
@RequestMapping("/index")
public class Index {
	@Autowired
	private CertificateCache cache;
	@GetMapping("/demo")
	public String check() {
		return cache.data;
	}
	@GetMapping("/test")
	public String test() {
		return "lotus";
	}
	@RequestMapping("/swagger")
    public String swagger() {
        return "redirect:swagger-ui.html";
    }
}
