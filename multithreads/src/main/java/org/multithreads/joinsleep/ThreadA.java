package org.multithreads.joinsleep;

public class ThreadA extends Thread {
	private ThreadB threadb;
	public ThreadA(ThreadB threadB) {
		super();
		this.threadb = threadB;
	}
	@Override
	public void run() {
			try {
				synchronized(threadb) {
					threadb.start();
				Thread.sleep(6000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
