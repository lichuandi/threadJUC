package com.lichuandi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/26
 * @Description：com.lichuandi.executor version：1
 */
public class FilxedThreadPool<mian> {
    public static void main(String[] args) {
        //固定大小的线程池
       /* ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            service.submit(new MyThreads());
        }
        service.shutdown();*/
        //单线程线程池
      /*  ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i <10 ; i++) {
            service.submit(new MyThreads());
        }
        service.shutdown();*/
        //
       /*ScheduledExecutorService service = Executors.newScheduledThreadPool(6);
        for (int i = 0; i <100 ; i++) {
            service.submit(new MyThreads());
        }
        service.schedule(new MyThreads(),100, TimeUnit.MICROSECONDS);
        service.schedule(new MyThreads(),100, TimeUnit.MICROSECONDS);
        service.shutdown();*/
        //可以缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            service.submit(new MyThreads());
        }
        service.shutdown();

    }
}
class MyThreads extends Thread{       @Override       public void run() {
    System.out.println(Thread.currentThread().getName()+"正在执行。。。");       }     }
