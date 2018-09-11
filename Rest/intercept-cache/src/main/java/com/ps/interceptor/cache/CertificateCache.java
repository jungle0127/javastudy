package com.ps.interceptor.cache;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CertificateCache {
	public static String data = null;
	public CertificateCache() {
		System.out.println("construct method.");
	}
	@PostConstruct
	public void init() {
		data = "CACHEDATA_POSTCONSTRUCT";
		System.out.println("init cache data");
	}

}
