package org.multithreads.reentranlock.sync;

public class ThreadB extends Thread {
	private MyService service;
	public ThreadB(MyService service) {
		super();
		this.service = service;
	}
	public void run() {
		this.service.methodB();
	}
}
