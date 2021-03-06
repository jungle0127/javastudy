package org.multithreads.synchonizedkeyword.klass;

public class SyncThread implements Runnable {
	private static int count;

	public SyncThread() {
		count = 0;
	}

	public static void method() {
		synchronized (SyncThread.class) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void run() {
		method();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
