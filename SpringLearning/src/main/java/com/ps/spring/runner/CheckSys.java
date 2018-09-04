package com.ps.spring.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component					
public class CheckSys implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sys check done.");
	}

}
