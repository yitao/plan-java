package com.simile.plan.java.thread;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by yitao on 2021/02/18.
 */
public class ThreadPoolExecutorApp {

    public static void main(String[] args) {
        LinkedBlockingQueue workQueue = new LinkedBlockingQueue(20);
        TaskThreadPoolExecutor executor = new TaskThreadPoolExecutor(
                10, 10, 0L, TimeUnit.MINUTES, workQueue);

        for (int i = 0; i < 30; i++) {
            final int fi = i;
            executor.execute(() -> {
                sleep(fi * 1000);
            });
        }

        executor.afterExecute(() -> {
            System.out.println("afterExecute");
        }, null);

        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void sleep(long ms) {
        try {
            System.out.println(new Date()+" "+Thread.currentThread().getName()+"sleep:" + ms);
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
