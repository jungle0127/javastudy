package org.multithreads.reentranlock.alternate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	
	public void set() {
		try {
			lock.lock();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("a");
			while(hasValue) {
				condition.await();
				System.out.println("b");
			}
			System.out.println("Print ***");
			hasValue = true;
			condition.signal();
			System.out.println("c");
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
			System.out.println("d");
		}
	}
	public void get() {
		try {
			this.lock.lock();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("1");
			while(!this.hasValue) {
				this.condition.await();
				System.out.println("2");
			}
			System.out.println("Print @@@");
			this.hasValue = false;
			this.condition.signal();
			System.out.println("3");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			this.lock.unlock();
			System.out.println("4");
		}
	}
}
