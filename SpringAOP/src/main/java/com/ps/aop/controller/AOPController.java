package com.ps.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {
	@GetMapping("/aop")
	public void checkAround() {
		System.out.println("aop controller");
	}
}
