package com.lichuandi.threadpool;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadpool version：1
 */
public class ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
       service.scheduleAtFixedRate(()->{
           try {
               TimeUnit.MICROSECONDS.sleep(new Random().nextInt(1000));
           }catch (InterruptedException e){
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName());
       },0,500,TimeUnit.MICROSECONDS) ;
    }
}
