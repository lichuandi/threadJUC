package com.lichuandi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadpool version：1
 */
public class SingleThread {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread("我是lichuandi");
            final  int j=i;
            service.execute(()->{
                //按顺序执行线程
                //System.out.println(j+" "+Thread.currentThread().getName());
                System.out.println(j+" "+thread.getName());
            });
        }
    }
}
