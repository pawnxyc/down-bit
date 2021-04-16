package com.wdbyte.downbit;

import com.wdbyte.downbit.thread.DownThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain {
    private static final int THREAD_COUNT = 1;

    private static ExecutorService executorService =  Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Future submit = executorService.submit(new DownThread("s"));
//        Future submit1 = executorService.submit(new DownThread("b"));
//        System.out.println(submit.get()+"====="+submit1.get());
//        executorService.shutdown();
        System.out.println(redi(5));
    }
    public static int redi(int n){
       return 1;
    }
}
