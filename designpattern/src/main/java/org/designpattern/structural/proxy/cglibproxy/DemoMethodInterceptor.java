package org.designpattern.structural.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DemoMethodInterceptor implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("BEFORE CGLIB");
		Object object = proxy.invokeSuper(obj, args); 
		System.out.println("AFTER CGLIB");
		return object;
	}

}
