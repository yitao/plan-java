package com.simile.plan.java.concurrency.scene1;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yitao on 2020/05/12
 */
public class StringBuilderMain {
    private static StringBuffer buffer = new StringBuffer();
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            T1 t1 = new T1(i);
            list.add(t1);
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            Thread thread = list.get(i);
            thread.start();
        }

        for (int i = 0; i < list.size() ; i++) {
            Thread thread = list.get(i);
            thread.join();
        }


        System.out.println(buffer.toString());
        System.out.println(builder.toString());
    }

    static class T1 extends Thread{
        int i;

        public T1(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            builder.append(i);
            buffer.append(i);
            System.out.println(Thread.currentThread().getName()+":over");
        }
    }
}
