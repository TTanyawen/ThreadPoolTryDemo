package com.example.threadpooltrydemo.createThread;

public class Method02 implements Runnable{

    @Override
    public void run()
    {
        System.out.println("线程启动了");
    }
    public static void main(String[] args)
    {
        Method02 m = new Method02();
        Thread t = new Thread(m);
        t.start();
    }
}
