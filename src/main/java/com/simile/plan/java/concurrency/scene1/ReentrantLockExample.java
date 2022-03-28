package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yitao
 * @Created 2022/03/28
 */
public class ReentrantLockExample {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new ThreadB(lock, condition).start();
        try {
            //等待 ThreadB 被调度
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ThreadA(lock, condition).start();
    }

    static class ThreadA extends Thread {
        ReentrantLock lock;
        Condition condition;

        public ThreadA(ReentrantLock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadA");
            lock.lock();
            try {
                System.out.println("ThreadA正在处理");
                Thread.sleep(1000);
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class ThreadB extends Thread {
        ReentrantLock lock;
        Condition condition;

        public ThreadB(ReentrantLock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadB:" + Thread.currentThread().getName());
            lock.lock();
            try {
                condition.await();
                System.out.println("ThreadB正在处理:" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
