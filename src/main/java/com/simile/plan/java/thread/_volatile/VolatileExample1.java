package com.simile.plan.java.thread._volatile;

/**
 * @Author yitao
 * @Created 2021/09/17
 */
public class VolatileExample1 {

	public static void main(String[] args) throws InterruptedException {
		VolatileModel volatileModel = new VolatileModel();
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (volatileModel) {
						int i = volatileModel.getI();
						for (int j = 0; j < 10000; j++) {

						}
						volatileModel.setI(i + 1);
					}
				}
			}).start();
		}

		Thread.sleep(1000);
		System.out.println("=" + volatileModel.getI());

	}


}
