package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author yitao
 * @Created 2022/03/28
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
//        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        new PollThread(queue).start();

        for (int i = 0; i < 10; i++) {
            new WriteThread(queue).start();
        }
    }

    /**
     * 模拟发送线程
     */
    static class WriteThread extends Thread {
        BlockingQueue<String> queue;

        public WriteThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("发送：" + Thread.currentThread().getName());
            this.queue.offer(Thread.currentThread().getName());
        }
    }

    /**
     * 模拟消费线程
     */
    static class PollThread extends Thread {
        BlockingQueue<String> queue;

        public PollThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String s = null;
                while ((s = this.queue.take()) != null) {
                    System.out.println("接收到：" + s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
