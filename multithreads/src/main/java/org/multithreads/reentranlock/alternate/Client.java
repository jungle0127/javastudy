package org.multithreads.reentranlock.alternate;

public class Client {

	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		ThreadB threadB = new ThreadB(service);
		threadA.start();
		threadB.start();
	}

}
