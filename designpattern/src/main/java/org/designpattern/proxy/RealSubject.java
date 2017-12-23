package org.designpattern.proxy;

public class RealSubject implements ISubject{
	public void doWork() {
		System.out.println("Do Work!");
	}

	public String getName() {
		return "Dynamic Proxy DEMO";
	}
}
