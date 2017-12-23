package org.multithreads.joinsleep;

public class ThreadC extends Thread {
	private ThreadB threadb;
	public ThreadC(ThreadB threadb) {
		super();
		this.threadb = threadb;
	}
	@Override
	public void run() {
		threadb.bService();
	}
}
