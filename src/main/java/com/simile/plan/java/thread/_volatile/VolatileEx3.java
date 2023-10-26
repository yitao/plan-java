package com.simile.plan.java.thread._volatile;

/**
 * @Author yitao
 * @Created 2023/07/26
 */
public class VolatileEx3 {
    private static volatile int key = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (VolatileEx3.class) {
                        try {
                            VolatileEx3.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(key);
                    }
                }
            }, "B").start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("aaa");
                }
            }, "B").start();

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (VolatileEx3.class) {
                        key = 1;
                        VolatileEx3.class.notifyAll();
                    }
                }
            }, "A").start();
        }

        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
