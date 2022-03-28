package com.simile.plan.java.concurrency.scene1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author yitao
 * @Created 2022/03/28
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        new PollThread(queue).start();
        for (int i = 0; i < 100; i++) {
            new WriteThread(queue).start();
        }

    }

    static class WriteThread extends Thread {
        Queue<String> queue;

        public WriteThread(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String val = Thread.currentThread().getName() + ":" + System.currentTimeMillis();
            try {
                //关键代码，避免竞争线程执行的太快
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.queue.offer(val);
        }
    }

    static class PollThread extends Thread {
        Queue<String> queue;

        public PollThread(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + this.queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
