package org.multithreads.reentranlock.multialternate;

public class ThreadA extends Thread {
	private MyService myService;
	
	public ThreadA(MyService myService) {
		super();
		this.myService = myService;
	}
	@Override
	public void run() {
		for(int index = 0; index < Integer.MAX_VALUE; index++) {
			this.myService.set();
		}
	}
}
