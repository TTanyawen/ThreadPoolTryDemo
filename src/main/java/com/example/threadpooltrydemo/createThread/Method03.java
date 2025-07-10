package com.example.threadpooltrydemo.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1. 实现Callable接口
 * 2. 创建FutureTask
 * 3. 创建Thread
 * 4. 启动Thread
 * 5. 获取回调结果
 */
public class Method03 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(i);
        }
        return 1;
    }
    public static void main(String[] args) throws InterruptedException {
        Method03 method03 = new Method03();
        FutureTask<Integer> futureTask = new FutureTask<>(method03);
        Thread t=new Thread(futureTask);
        System.out.println("t.start();");
        t.start();//start方法调用后，call方法执行
        Thread.sleep(5000);
        System.out.println("t.start();~");
        try{
            Integer res=futureTask.get();
            System.out.println(res);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

    }
}
