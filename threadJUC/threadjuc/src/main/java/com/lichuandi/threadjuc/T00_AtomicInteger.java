package com.lichuandi.threadjuc;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class T00_AtomicInteger {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        Thread[] thread=new Thread[100];
        //等待线程结束的
        CountDownLatch countDownLatch=new CountDownLatch(thread.length);
        for (int i=0;i<thread.length;i++){
            thread[i]=new Thread(()->{
                for (int j=0;j<100;j++){
                    atomicInteger.incrementAndGet();//替代atomicInteger++

                }
                countDownLatch.countDown();
            });
        }
        Arrays.stream(thread).forEach((t)->t.start());
        countDownLatch.await();
        System.out.println(atomicInteger);
    }

}
