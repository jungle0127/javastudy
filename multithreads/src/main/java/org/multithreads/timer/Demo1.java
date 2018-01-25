package org.multithreads.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println("Current time:" + new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 3);
		Date runDate = calendar.getTime();
		MyTask task = new MyTask();
		Timer timer = new Timer();
		timer.schedule(task, runDate, 5000);
	}

}
