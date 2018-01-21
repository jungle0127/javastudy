package org.multithreads.reentranlock.alternate;

public class ThreadB extends Thread {
	private MyService myService;
	public ThreadB(MyService myService) {
		super();
		this.myService = myService;
	}
	@Override
	public void run() {
		for(int index = 0; index < Integer.MAX_VALUE;index++) {
			this.myService.get();
		}
	}
}
