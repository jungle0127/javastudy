package com.ps.spring.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements CommandLineRunner {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void run(String... args) throws Exception {
		this.redisTemplate.opsForValue().set("key", "value");
		String val = String.valueOf(this.redisTemplate.opsForValue().get("key"));
		System.out.println(val);
	}

}
