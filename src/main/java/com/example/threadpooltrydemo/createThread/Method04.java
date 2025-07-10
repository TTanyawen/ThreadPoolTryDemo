package com.example.threadpooltrydemo.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method04 implements Runnable{
    @Override
    public void run()
    {
        System.out.println("Method04"+Thread.currentThread().getName());
    }
    public static void main(String[] args)
    {
        //创建线程池，内含10个线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            executorService.execute(new Method04());//提交任务到线程池
        }
        executorService.shutdown();//关闭线程池

    }
}
