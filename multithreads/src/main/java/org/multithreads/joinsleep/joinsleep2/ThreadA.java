package org.multithreads.joinsleep.joinsleep2;

import java.util.List;

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
					threadb.join();
					for(int i =0; i < Integer.MAX_VALUE; i++) {
						System.out.println("begin run...");
						Thread.sleep(1000);
						String newstr = new String();
						Math.random();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
