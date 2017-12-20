package com.javastudy.designpattern.proxy;

public class RealSubject implements ISubject{
	public void doWork() {
		System.out.println("Do Work!");
	}

	@Override
	public String getName() {
		return "Dynamic Proxy DEMO";
	}
}
