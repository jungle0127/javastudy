package org.multithreads.reentranlock.multialternate;

public class Client {

	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA[] threadA = new ThreadA[10];
		ThreadB[] threadB = new ThreadB[10];
		for(int index = 0;index < 10; index++) {
			threadA[index] = new ThreadA(service);
			threadB[index] = new ThreadB(service);
			threadA[index].start();
			threadB[index].start();
		}
	}

}
