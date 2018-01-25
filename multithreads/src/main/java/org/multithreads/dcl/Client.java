package org.multithreads.dcl;

public class Client {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		MyThread thread3 = new MyThread();
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
