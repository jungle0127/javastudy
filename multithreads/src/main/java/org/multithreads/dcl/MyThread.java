package org.multithreads.dcl;

public class MyThread extends Thread {
	public void run() {
		System.out.println(DCLSingleton.getInstance().hashCode());
	}
}
