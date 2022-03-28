package com.simile.plan.java.concurrency.scene1;

/**
 * 当我们需要控制两个线程（代码）执行顺序的时候
 * 可以利用Object的wait和notify，需要注意的是该操作需要在锁对象中使用
 * <p>
 * 当使用重入锁的时候，则可以使用Condition进行控制。
 * 参考<ref>ReentrantLockExample</ref>
 *
 * @Author yitao
 * @Created 2022/03/28
 */
public class ObjectWaitNotifyExample {

    public static void main(String[] args) {
        Object obj = new Object();
        new ThreadB(obj).start();
        try {
            //等待 ThreadB 被调度
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ThreadA(obj).start();
    }

    static class ThreadA extends Thread {
        Object obj;

        public ThreadA(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadA");
            synchronized (obj) {
                try {
                    System.out.println("ThreadA正在处理");
                    Thread.sleep(1000);
                    obj.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        Object obj;

        public ThreadB(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            System.out.println("进入ThreadB:" + Thread.currentThread().getName());
            synchronized (obj) {
                try {
                    obj.wait();
                    System.out.println("ThreadB正在处理:" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
