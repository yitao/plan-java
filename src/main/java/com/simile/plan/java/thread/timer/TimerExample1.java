package com.simile.plan.java.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author yitao
 * @Created 2021/09/17
 */
public class TimerExample1 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println(String.format("%s doing.at %s", Thread.currentThread().getName(), new Date()));
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, 0, 1000);
		timer.cancel();
		//java.lang.IllegalStateException: Timer already cancelled.
//		timer.schedule(task, 0, 3000);
	}
}
