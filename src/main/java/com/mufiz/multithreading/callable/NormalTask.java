package com.mufiz.multithreading.callable;

public class NormalTask {
    private int i;

    public NormalTask(int i) {
        this.i = i;
    }

    public String call(){
        String result;
        if(i%5 == 0 ){
//            System.out.println("waiting for index"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("returning from index "+i);
            result = "failure";
        } else {
//            System.out.println("returning from index "+i);
            result = "success";
        }
        return result;
    }
}
