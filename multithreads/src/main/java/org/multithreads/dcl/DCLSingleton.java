package org.multithreads.dcl;

public class DCLSingleton {
	private volatile static DCLSingleton singleton;
	private DCLSingleton() {
		
	}
	public static DCLSingleton getInstance() {
		if(singleton == null) {
			synchronized(DCLSingleton.class){
				if(singleton == null) {
					singleton = new DCLSingleton();
				}
			}
		}
		return singleton;
	}
}
