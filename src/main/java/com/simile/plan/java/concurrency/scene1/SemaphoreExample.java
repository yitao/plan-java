package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.Semaphore;

/**
 * 信号量 示例
 * @Author yitao
 * @Created 2022/07/24
 */
public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        Semaphore available = new Semaphore(10, true);
        available.acquire();
        available.acquire(1);

        available.release();
        available.release();
    }
}
