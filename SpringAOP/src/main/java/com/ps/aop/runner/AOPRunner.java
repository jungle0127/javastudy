package com.ps.aop.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AOPRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		System.out.println("AOP runner do something...");
	}

}
