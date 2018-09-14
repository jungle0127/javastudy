package com.ps.spring.runner;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component					
public class CheckSys implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sys check done.");
		List<String> uriList = new LinkedList<String>();
		uriList.add("/authorization/login");
		uriList.add("/authorization/error");
		System.out.println(uriList.contains("/authorization/login"));
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid.replace("-", "").length());
		
	}

}
