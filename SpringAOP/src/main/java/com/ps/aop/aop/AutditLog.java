package com.ps.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@EnableAspectJAutoProxy
public class AutditLog {
	@Pointcut("execution(* com.ps.aop.runner.AOPRunner.run(..))")
	public void runnerMethod() {
		
	}
	@Around("runnerMethod()")
	public Object aroundLogic(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around AOP interceptor.");
		Object obj = pjp.proceed(); 
		System.out.println("Around AOP interceptor.");
		return obj;
	}
	@Before("runnerMethod()")
	public void beforeJointpoint() {
		System.out.println("Before the joint point.");
	}
}
