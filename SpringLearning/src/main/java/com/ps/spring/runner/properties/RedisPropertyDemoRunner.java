package com.ps.spring.runner.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisPropertyDemoRunner implements CommandLineRunner {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.database}")
	private int database;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.host);
	}

}
