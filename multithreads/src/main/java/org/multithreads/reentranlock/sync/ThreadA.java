package org.multithreads.reentranlock.sync;

public class ThreadA extends Thread {
	private MyService myService;
	
	public ThreadA(MyService service) {
		super();
		this.myService = service;
	}
	public void run() {
		this.myService.methodA();
	}
}
