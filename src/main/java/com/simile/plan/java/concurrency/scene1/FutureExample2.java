package com.simile.plan.java.concurrency.scene1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author yitao
 * @Created 2023/04/19
 */
public class FutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() {
                return 111;
            }
        });
        task.run();

        System.out.println(task.get());
        System.out.println("----");

        String a = null;
        FutureTask task2 = new FutureTask<String>(new Runnable() {
            @Override
            public void run() {

            }
        }, a);

        task2.run();
        Object b = task2.get();

        System.out.println(a);
        System.out.println(b);
    }


}
