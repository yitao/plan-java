package com.simile.plan.java.other;

/**
 * @Author yitao
 * @Created 2023/10/23
 */

import java.util.concurrent.TimeUnit;

/**
 * 漏桶算法
 */
public class LeakyBucket {
    //容量，超过容量则不提供服务
    private int capacity;
    private int tokens;
    //上次放行时间
    private long lastLeakTime;
    //放行间隔
    private long leakInterval;

    public LeakyBucket(int capacity, long tokensPerSecond) {
        this.capacity = capacity;
        this.tokens = 0;
        this.leakInterval = 1000L / tokensPerSecond;
        this.lastLeakTime = System.currentTimeMillis();
    }

    public boolean acceptRequest() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastLeakTime;
        int leakedTokens = (int) (elapsedTime / leakInterval);
        tokens = Math.max(0, tokens - leakedTokens);

        if (tokens < capacity) {
            tokens++;
            lastLeakTime = currentTime;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 10 capacity with 2 tokens per second
        LeakyBucket leakyBucket = new LeakyBucket(10, 2);

        for (int i = 0; i < 20; i++) {
            if (leakyBucket.acceptRequest()) {
                System.out.println("Request " + i + " is processed.");
            } else {
                System.out.println("Request " + i + " is rate-limited.");
            }
            try {
                // Sleep for 50 milliseconds
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
