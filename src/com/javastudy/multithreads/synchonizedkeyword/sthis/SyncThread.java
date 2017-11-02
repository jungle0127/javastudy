package com.javastudy.multithreads.synchonizedkeyword.sthis;
/*
 * synchronized 是Java中的关键字，是一种同步锁
 * 1. 修改一个代码块，被修饰的代码块为同步语句块，其作用的范围是大括号括起来的代码，作用的对象是调用这个代码块的对象
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞。
 * 当一个线程访问对象的一个synchronized(this)同步代码块时，其他线程仍然可以访问该对象中非synchronized(this)代码块
 */
public class SyncThread implements Runnable {
	private static int count;
	public SyncThread(){
		count = 0;
	}
	@Override
	public void run() {
		synchronized(this){
			for(int i = 0; i< 5;i++){
				try{
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	public int getCount(){
		return count;
	}
	public static void main(String[] args) {
		SyncThread syncThread = new SyncThread();
		Thread thread1 = new Thread(syncThread, "SyncThread1");
		Thread thread2 = new Thread(syncThread, "SyncThread2");
		thread1.start();
		thread2.start();
	}

}
