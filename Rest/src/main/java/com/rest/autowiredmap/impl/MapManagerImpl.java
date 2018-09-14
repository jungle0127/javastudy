package com.rest.autowiredmap.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.autowiredmap.MapManager;
import com.rest.autowiredmap.MapProvider;
@Component
public class MapManagerImpl implements MapManager {
	@Autowired
	private Map<String, MapProvider> providerMap;
	@Override
	public void config() {
		for(Entry<String, MapProvider> entry: providerMap.entrySet()) {
			System.out.println("------------------BEGIN-------------------------");
			System.out.println(entry.getKey());
			entry.getValue().config();
			System.out.println("------------------END-------------------------");
		}

	}

}
