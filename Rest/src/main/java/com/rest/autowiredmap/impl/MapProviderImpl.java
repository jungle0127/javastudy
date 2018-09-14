package com.rest.autowiredmap.impl;

import org.springframework.stereotype.Component;

import com.rest.autowiredmap.MapProvider;
@Component
public class MapProviderImpl implements MapProvider {

	@Override
	public void config() {
		System.out.println("Default Provider");

	}

}
