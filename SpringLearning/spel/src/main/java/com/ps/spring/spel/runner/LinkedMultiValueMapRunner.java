package com.ps.spring.spel.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
@Component
public class LinkedMultiValueMapRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(LinkedMultiValueMapRunner.class);
	
	public void run(String... args) throws Exception {
		LinkedMultiValueMap<String, String> multipartRequest = new LinkedMultiValueMap<String, String>();
		multipartRequest.add("jinghe", "lotus");
		multipartRequest.add("jinghe", "ps");
		logger.info(multipartRequest.getFirst("jinghe"));
	}
	
}
