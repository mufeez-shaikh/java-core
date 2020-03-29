package com.mufiz.concurrent;

public class ThreadMain {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(() ->{
                System.out.println("thread is sleeping");
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "exiting thread");
            });
            t.start();
        }
        System.out.println(Thread.currentThread().getName() + " main exited");

        System.out.println(Runtime.getRuntime().availableProcessors());







    }



}
