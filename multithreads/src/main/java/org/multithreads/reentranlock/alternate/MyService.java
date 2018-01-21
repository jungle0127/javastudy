package org.multithreads.reentranlock.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	
	public void set() {
		try {
			lock.lock();
			while(hasValue) {
				condition.await();
			}
			System.out.println("Print ***");
			hasValue = true;
			condition.signal();
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	public void get() {
		try {
			this.lock.lock();
			while(!this.hasValue) {
				this.condition.await();
			}
			System.out.println("Print @@@");
			this.hasValue = false;
			this.condition.signal();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			this.lock.unlock();
		}
	}
}
