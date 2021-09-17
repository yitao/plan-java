package com.simile.plan.java.thread;

import java.util.Date;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/05/24
 */
public class ContextTest {

    @Test
    public void test() {
        Context context = new Context();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    context.sign++;
                    System.out.println(">" + Thread.currentThread().getName() + " " + new Date().toInstant() + " " + context.sign);
//                    try {
//                        Thread.sleep(100L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    context.sign++;
                    System.out.println(">" + Thread.currentThread().getName() + " " + new Date().toInstant() + " " + context.sign);
//                    try {
//                        Thread.sleep(100L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + new Date().toInstant() + " " + context.sign);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + new Date().toInstant() + " " + context.sign);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " " + new Date().toInstant() + " " + context.sign);

    }

}