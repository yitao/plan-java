package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时锁
 * 当一个线程依赖其他的线程的N次操作后进行运行的场景。
 * 这个N次为倒计时锁设定的值。假设你的A线程们要执行1000次，你可以使用"倒计时锁"控制线程B在A线程们执行10次后开始执行
 *
 * @Author yitao
 * @Created 2022/03/28
 */
public class CountDownLatchExample {

    public static void main(String[] args) {
        //倒计时锁
        CountDownLatch countDownLatch = new CountDownLatch(10);

        new ThreadB(countDownLatch).start();
        try {
            //等待 ThreadB 被调度
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ThreadA(countDownLatch).start();

    }


    static class ThreadA extends Thread {
        CountDownLatch countDownLatch;

        public ThreadA(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadA");
            for (int i = 0; i < 13; i++) {
                try {
                    System.out.println("ThreadA正在处理:" + i);
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        CountDownLatch countDownLatch;

        public ThreadB(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadB");
            try {
                countDownLatch.await();
                System.out.println("ThreadB正在处理");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
