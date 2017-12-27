package org.multithreads.reentranlock.sync;

public class ThreadAA extends Thread {
	private MyService service;
	public ThreadAA(MyService service) {
		super();
		this.service = service;
	}
	public void run() {
		this.service.methodA();
	}
}
