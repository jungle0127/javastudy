package com.rest.autowiredlist;

import org.springframework.stereotype.Component;

@Component
public class ConcreteSomethingProvider implements SomethingProvider {

	@Override
	public boolean config(String str) {
		System.out.println("Lotus + " + str);
		return false;
	}

}
