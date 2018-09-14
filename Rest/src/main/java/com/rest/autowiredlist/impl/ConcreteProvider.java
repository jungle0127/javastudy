package com.rest.autowiredlist.impl;

import org.springframework.stereotype.Component;

import com.rest.autowiredlist.SomethingProvider;

@Component
public class ConcreteProvider implements SomethingProvider {

	@Override
	public boolean config(String str) {
		System.out.println(str);
		return false;
	}

}
