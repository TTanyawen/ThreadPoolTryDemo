package com.example.threadpooltrydemo.createThread;


class Method01 extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread类创建线程");
    }
    public static void main(String[] args) {
        Method01 t = new Method01();
        t.start();
    }
}

