package com.simile.plan.java.other;

/**
 * @Author yitao
 * @Created 2023/10/23
 */

/**
 * 计数器
 */
public class RateLimiter {
    //固定时间内支持访问的数量
    private long visitLimit;
    //访问控制的固定时间
    private long ctlTime;
    //最后一次访问时间
    private long lastVisitTime;
    //本周期内的访问次数
    private int visitCount;

    public RateLimiter(long visitLimit, long ctlTime) {
        this.visitLimit = visitLimit;
        this.ctlTime = ctlTime;
    }

    public boolean allow() {
        long currentTs = System.currentTimeMillis();
        if (currentTs - lastVisitTime > ctlTime) {
            //如果当前时间距离最后一次访问时间已经超出了控制时间，则重置访问次数
            visitCount = 0;
            lastVisitTime = currentTs;
        }
        if (visitCount >= visitLimit) {
            //如果当前访问量已经大于等于访问限制数，则不提供访问
            return false;
        }
        visitCount++;
        return true;
    }

    public static void main(String[] args) {
        // 每20毫秒最多1个请求
        RateLimiter rateLimiter = new RateLimiter(1, 20);

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

