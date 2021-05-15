package com.lichuandi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadpool version：1
 */
public class cachedPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for (int i = 0; i <2 ; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
            System.out.println(service);
            TimeUnit.SECONDS.sleep(80);
            System.out.println(service);
        }
    }
}
