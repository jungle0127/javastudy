package org.multithreads.joinsleep.joinsleep2;

public class ThreadC extends Thread {
	private ThreadB threadb;
	public ThreadC(ThreadB threadb) {
		super();
		this.threadb = threadb;
	}
	@Override
	public void run() {
		System.out.println("1");
		threadb.bService();
		System.out.println(2);
	}
}
