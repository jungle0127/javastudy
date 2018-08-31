package com.rest.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.autowiredlist.SomthingManager;

@Component
public class CheckAutowiredList implements CommandLineRunner {
	@Autowired
	private SomthingManager somthingManager;
	@Override
	public void run(String... args) throws Exception {
		this.somthingManager.config("");
	}

}
