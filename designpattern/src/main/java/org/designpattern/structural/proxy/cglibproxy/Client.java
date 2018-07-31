package org.designpattern.structural.proxy.cglibproxy;

import org.designpattern.structural.proxy.ISubject;
import org.designpattern.structural.proxy.RealSubject;

import net.sf.cglib.proxy.Enhancer;

public class Client {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RealSubject.class);
		enhancer.setCallback(new DemoMethodInterceptor());
		ISubject subject = (ISubject) enhancer.create();
		subject.doWork();
		System.out.println(subject.getName());
	}
	
}
