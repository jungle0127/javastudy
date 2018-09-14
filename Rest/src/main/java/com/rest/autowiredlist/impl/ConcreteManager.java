package com.rest.autowiredlist.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.autowiredlist.SomethingProvider;
import com.rest.autowiredlist.SomthingManager;

@Component
public class ConcreteManager implements SomthingManager {
	@Autowired
	private List<SomethingProvider> providerList;
	@Override
	public void config(String str) {
		for(SomethingProvider provider: providerList) {
			provider.config("jinghe");
		}
	}

}
