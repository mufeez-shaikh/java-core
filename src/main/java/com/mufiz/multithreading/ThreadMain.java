package com.mufiz.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class ThreadMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        // create tasks
        List<CallableTask> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new CallableTask(i));
        }

        // add tasks to executor service.
        CompletableFuture[] cFutures = tasks.stream()
                .map(t -> CompletableFuture.supplyAsync(t,service))
                .toArray(CompletableFuture[]::new);

        // wait for all tasks to complete.
        CompletableFuture.allOf(cFutures).join();
        for (int i = 0; i < cFutures.length; i++) {
            CompletableFuture cFuture = cFutures[i];
            System.out.println(cFuture.get());
        }
        service.shutdown();
        System.out.println("main complete");
    }

    static class CallableTask implements Supplier<Integer> {

        private int i;

        public CallableTask(int i) {
            this.i = i;
        }

        @Override
        public Integer get(){
            if(i==3 ){
                System.out.println("waiting for thread 3");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return i+10;
        }
    }
}
