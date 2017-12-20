package com.javastudy.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxySubject implements InvocationHandler {
	private ISubject subject;
	public JDKProxySubject(RealSubject subject) {
		this.subject = subject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("###Before###");
		Object result = method.invoke(this.subject, args);
		
		return result;
	}

}
