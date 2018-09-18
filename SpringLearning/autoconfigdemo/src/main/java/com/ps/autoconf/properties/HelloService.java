package com.ps.autoconf.properties;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	private String msg = "service";
	public void say() {
		System.out.println("Hello " + msg);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
