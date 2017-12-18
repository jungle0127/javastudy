package com.javastudy.multithreads.joinsleep;

public class ThreadB extends Thread {
	@Override
	public void run() {
		try {
			System.out.println(" B run begin time:>" + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("B run end time:" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public void bService() {
		System.out.println("打印了B service timer=" + System.currentTimeMillis());
	}
}
