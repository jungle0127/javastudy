package org.multithreads.reentranlock.fairnofair;

import java.util.concurrent.locks.ReentrantLock;

public class Service {
	private ReentrantLock lock;
	public Service(boolean isFair) {
		super();
		this.lock = new ReentrantLock(isFair);
	}
	
	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + " got lock;");
		}
		finally {
			this.lock.unlock();
		}
	}
}
