package com.rest.autowiredlist;

import org.springframework.stereotype.Component;

@Component
public class ConcreteProvider implements SomethingProvider {

	@Override
	public boolean config(String str) {
		System.out.println(str);
		return false;
	}

}
