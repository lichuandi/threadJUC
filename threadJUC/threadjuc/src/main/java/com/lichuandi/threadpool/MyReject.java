package com.lichuandi.threadpool;

import java.util.concurrent.*;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadpool version：1
 */
public class MyReject {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6)
                , Executors.defaultThreadFactory(), new MyHandler());
    }
    static  class MyHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (executor.getQueue().size()<10000);
        }
    }
}

