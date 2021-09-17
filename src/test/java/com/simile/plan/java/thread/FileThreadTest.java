package com.simile.plan.java.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/05/25
 */
public class FileThreadTest {

    private String path = "/Users/haizhi/Documents/workspace/work/plan-java/1.txt";

    ReentrantLock lock = new ReentrantLock(true);
    int size = 16;
    @Test
    public void test() {

        new Thread(() -> {
            for (int i = 0; i < size; i++) {
                lock.lock();
                File file = new File(path);
                try {
                    System.out.println(">>>>>>>>>>");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("<<<<<<<<<<");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < size; i++) {
                File file = new File(path);
                byte[] buffer = String.valueOf(i).getBytes();
                lock.lock();
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    outputStream.write(buffer);
                    outputStream.flush();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }).start();


        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static class T2 extends Thread {

        @Override
        public void run() {

        }
    }

}
