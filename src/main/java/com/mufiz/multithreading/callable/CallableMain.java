package com.mufiz.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) throws InterruptedException {
        CallableMain cm = new CallableMain();
        cm.testThread();
    }

    /**
     * compares time taken between sequential and parallel processing.
     * @throws InterruptedException
     */
    public void testThread() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        // create tasks.
        List<CallableTask> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(new CallableTask(i));
        }
        long t1 = System.currentTimeMillis();
        // ask executorService to execute all tasks
        List<Future<TaskResult>> futures = es.invokeAll(tasks);

        List<Integer> success = new ArrayList<>();
        List<Integer> failure = new ArrayList<>();

        //capture results of each task and add to collection.
        futures.forEach(f -> {
            try {
                success.addAll(f.get().getSuccess());
                failure.addAll(f.get().getFailure());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        es.shutdown();
        long ct2 = System.currentTimeMillis() - t1;
        System.out.println("multi threadying: " + ct2);

        // sequential task execution.
        List<NormalTask> tasks1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks1.add(new NormalTask(i));
        }

        long t2 = System.currentTimeMillis();
        for (NormalTask task : tasks1) {
            task.call();
        }
        long nt1 = System.currentTimeMillis() - t2;
        System.out.println("sequential: " + nt1);
    }
}
