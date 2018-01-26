package org.multithreads.reentranlock.fairnofair;

public class FairDemo {

	public static void main(String[] args) {
		final Service service = new Service(true);
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread** " + Thread.currentThread().getName() + " gonna run:");
				service.serviceMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for(int index = 0;index< 10;index++) {
			threadArray[index] = new Thread(runnable);
		}
		for(int index = 0;index< 10;index++) {
			threadArray[index].start();
		}
	}

}
