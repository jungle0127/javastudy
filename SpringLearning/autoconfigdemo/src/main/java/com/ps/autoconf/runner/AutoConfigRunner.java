package com.ps.autoconf.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ps.autoconf.properties.HelloService;
@Component
public class AutoConfigRunner implements CommandLineRunner{
	@Autowired
	private HelloService helloService;
	
	@Override
	public void run(String... args) throws Exception {
		helloService.say();
	}

}
