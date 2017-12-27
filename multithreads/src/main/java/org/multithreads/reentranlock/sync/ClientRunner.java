package org.multithreads.reentranlock.sync;

public class ClientRunner {

	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		ThreadAA threadAA = new ThreadAA(service);
		ThreadB threadB = new ThreadB(service);
		ThreadBB threadBB = new ThreadBB(service);
		threadA.setName("A");
		threadAA.setName("AA");
		threadBB.setName("BB");
		threadB.setName("B");
		threadA.start();
		threadAA.start();
		threadB.start();
		threadBB.start();
	}

}
