package com.simile.plan.java.concurrency.scene1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author yitao
 * @Created 2023/04/19
 */
public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new FutureExample().core();
    }


    public FutureExample() {
        int coreSize = 4;
        int maxSize = 5;
        long keepAliveTime = 7200;
        LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
        this.executorService = new ThreadPoolExecutor(
                coreSize, maxSize,
                keepAliveTime, TimeUnit.SECONDS,
                queue,
                new ThreadPoolExecutor.AbortPolicy());
    }

    private ThreadPoolExecutor executorService;

    private void core() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Long>> futures = new ArrayList();
        for (int i = 0; i < 10; i++) {
            long slp = new Random().nextInt((i + 1) * 10) * 100 + 1000L;
            String name = "正在处理name" + i;
            CompletableFuture<Long> future =
                    CompletableFuture.supplyAsync(() -> process(slp, name), executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf((CompletableFuture[]) futures.toArray(new CompletableFuture[futures.size()]));
        List<Long> results = allDoneFuture.thenApply((v) -> {
            return (List<Long>) futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        }).get();
        System.out.println(results);

        this.executorService.shutdownNow();
    }

    private Long process(long slp, String name) {
        try {
            Thread.sleep(slp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        return slp;
    }


}
