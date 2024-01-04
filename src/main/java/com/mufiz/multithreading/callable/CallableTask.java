package com.mufiz.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<TaskResult> {

    private Integer i;

    public CallableTask(Integer i) {
        this.i = i;
    }

    @Override
    public TaskResult call() throws Exception {
        List<Integer> success = new ArrayList<>();
        List<Integer> failure = new ArrayList<>();
        if(i%5 == 0 ){
//            System.out.println("waiting for index"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("returning from index "+i);
            failure.add(i);
        } else {
//            System.out.println("returning from index "+i);
            success.add(i);
        }
        return new TaskResult(success, failure);
    }

    public TaskResult run() throws Exception {
        List<Integer> success = new ArrayList<>();
        List<Integer> failure = new ArrayList<>();
        if(i%5 == 0 ){
//            System.out.println("waiting for index"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("returning from index "+i);
            failure.add(i);
        } else {
//            System.out.println("returning from index "+i);
            success.add(i);
        }
        return new TaskResult(success, failure);
    }
}
