package org.multithreads.reentranlock.multialternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	
	public void set() {
		try {
			lock.lock();
			System.out.println("a");
			while(hasValue) {
				condition.await();
				System.out.println("b may sequence");
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
			System.out.println("1");
			while(!this.hasValue) {
				this.condition.await();
				System.out.println("2 may sequence");
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
