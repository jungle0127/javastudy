package org.multithreads.reentranlock.sync;

public class ThreadBB extends Thread {
	private MyService service;
	public ThreadBB(MyService service) {
		super();
		this.service = service;
	}
	public void run() {
		this.service.methodB();
	}
}
