package com.simile.plan.java.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yitao on 2021/02/18.
 */
public class TaskThreadPoolExecutor extends ThreadPoolExecutor {


    public TaskThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        r.run();
    }
}
