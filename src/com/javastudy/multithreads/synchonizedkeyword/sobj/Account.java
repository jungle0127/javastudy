package com.javastudy.multithreads.synchonizedkeyword.sobj;
/*
 * 指定要给某个对象加锁
 */
public class Account {
	private String name;
	private float ammout;
	public Account(String name, float ammout){
		this.name = name;
		this.ammout = ammout;
	}
	
	public void deposit(float amt){
		this.ammout += amt;
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void withdraw(float amt){
		this.ammout -= amt;
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public float getBalance(){
		return this.ammout;
	}
}
