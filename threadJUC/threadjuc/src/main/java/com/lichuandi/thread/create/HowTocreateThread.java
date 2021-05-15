package com.lichuandi.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.thread.create version：1
 */
public class HowTocreateThread {
    public static void main(String[] args) {
    //启动线程的方式
    new MyThread().start();
    new Thread(new MyRun()).start();
    new Thread(()->{
        System.out.println("lambda");
    }).start();
        Thread thread = new Thread(new FutureTask<String>(new MYCall()));
        thread.start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("woshi ThreadPool");
        });
        service.shutdown();
    }
static class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("woshi thread");
    }
}
static class MyRun implements Runnable{
    @Override
    public void run() {
        System.out.println("wosho Myrun");
    }
}
static  class MYCall implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("woshi Mycall");
        return "success";
    }

}
}
