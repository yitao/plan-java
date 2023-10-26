package com.simile.plan.java.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yitao
 * @Created 2023/10/23
 */
public class SlidingWindowRateLimiter {
    //固定时间内支持访问的数量
    private long limit;
    //访问控制的固定时间
    private long windowSize;
    // 时间戳队列
    private Queue<Long> timestamps;

    public SlidingWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timestamps = new LinkedList<>();
    }

    public boolean allow() {
        long currentTime = System.currentTimeMillis();

        // 移除超过时间窗口的时间戳
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() > windowSize) {
            timestamps.poll();
        }

        // 如果时间戳数量小于限制，允许通过
        if (timestamps.size() < limit) {
            timestamps.offer(currentTime);
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        // 每20毫秒最多1个请求
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(1, 20);

        for (int i = 0; i < 10; i++) {
            if (rateLimiter.allow()) {
                System.out.println("Request " + i + " is processed.");
            } else {
                System.out.println("Request " + i + " is rate-limited.");
            }
            try {
                // Sleep for 10 milliseconds
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
