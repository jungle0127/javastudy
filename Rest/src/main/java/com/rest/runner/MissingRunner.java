package com.rest.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.conditionmissingbean.IInfoService;
import com.rest.conditionmissionclass.INameService;
@Component
public class MissingRunner implements CommandLineRunner {
	@Autowired
	private INameService nameService;
	@Autowired
	private IInfoService infoService;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.nameService.getName());
		System.out.println(this.infoService.getName());
	}

}
