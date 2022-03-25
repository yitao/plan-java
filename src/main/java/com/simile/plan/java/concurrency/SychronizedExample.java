package com.simile.plan.java.concurrency;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author yitao
 * @Created 2022/03/24
 */
public class SychronizedExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------user0 --------");
        User user0 = new User();
        System.out.println("未锁定时：");
        System.out.println(
                ClassLayout.parseInstance(user0).toPrintable()
        );

        System.out.println("-------休息5s user--------");
        Thread.sleep(5000);
        User user = new User();
        System.out.println("未锁定时：");
        System.out.println(
                ClassLayout.parseInstance(user).toPrintable()
        );


        synchronized (user) {
            System.out.println("main线程synchronized锁定时：");
            System.out.println(
                    ClassLayout.parseInstance(user).toPrintable()
            );
        }

        System.out.println("结束main线程synchronized锁定时：");
        System.out.println(
                ClassLayout.parseInstance(user).toPrintable()
        );


        System.out.println("---------------------------");
        System.out.println("单个线程多次同步操作");
        //理论上，偏向锁为针对于同一线程进入多次
        //-XX:-UseBiasedLocking 关闭偏向锁
        //-XX:+UseBiasedLocking 开启偏向锁
        //-XX:BiasedLockingStartupDelay=0 关闭延迟开启偏向锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    synchronized (user) {
                        System.out.println("thread:" + Thread.currentThread().getName() + ":" + i + "锁定时");
                        System.out.println(
                                ClassLayout.parseInstance(user).toPrintable()
                        );
                    }
                }
                synchronized (user) {
                    System.out.println("thread:" + Thread.currentThread().getName() + ":(2)" + "锁定时");
                    System.out.println(
                            ClassLayout.parseInstance(user).toPrintable()
                    );
                }
                synchronized (user) {
                    System.out.println("thread:" + Thread.currentThread().getName() + ":(3)" + "锁定时");
                    System.out.println(
                            ClassLayout.parseInstance(user).toPrintable()
                    );
                }
            }
        }).start();


        Thread.sleep(5000);
        System.out.println("---------------------------");
        System.out.println("以下快要被多个线程锁定了！！！！！！");
        //多个线程争抢同一个锁，则触发重量级锁
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (user) {
                        System.out.println("thread:" + Thread.currentThread().getName() + "锁定时");
                        System.out.println(
                                ClassLayout.parseInstance(user).toPrintable()
                        );
                    }
                }
            }).start();
        }

        Thread.sleep(5000);

        System.out.println("===main end===");
        System.out.println(
                ClassLayout.parseInstance(user).toPrintable()
        );


    }


}

class User {

}
