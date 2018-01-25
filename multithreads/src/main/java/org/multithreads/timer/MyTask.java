package org.multithreads.timer;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Task runned with time:" + new Date().toString());
	}

}
