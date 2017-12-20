package com.javastudy.designpattern.proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		ISubject subject = (ISubject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[] {ISubject.class},new JDKProxySubject(new RealSubject()));
		
		subject.doWork();
		System.out.println(subject.getName());
	}
}
