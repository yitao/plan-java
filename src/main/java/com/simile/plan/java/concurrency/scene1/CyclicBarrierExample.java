package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 * 可控制一组线程达到都到达栅栏后，同时继续执行
 *
 * @Author yitao
 * @Created 2022/03/28
 */
public class CyclicBarrierExample {


    public static void main(String[] args) {
        //栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new ThreadB(cyclicBarrier).start();
        try {
            //等待 ThreadB 被调度
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ThreadA(cyclicBarrier).start();

    }


    static class ThreadA extends Thread {
        CyclicBarrier cyclicBarrier;

        public ThreadA(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadA");
            for (int i = 0; i < 13; i++) {
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ":ThreadA正在处理:A" + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        CyclicBarrier cyclicBarrier;

        public ThreadB(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadB");
            try {
                for (int i = 0; i < 13; i++) {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ":ThreadB正在处理:B" + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
