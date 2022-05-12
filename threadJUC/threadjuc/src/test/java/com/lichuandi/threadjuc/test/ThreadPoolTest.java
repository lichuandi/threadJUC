package com.lichuandi.threadjuc.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author digege
 * @date 2021/10/28 11:07
 * @description：TODO
 * @page com.lichuandi.threadjuc.test
 * version：1
 */
@SpringBootTest
public class ThreadPoolTest {

    int corePoolSize = 3;
    int maximumPoolSize = 5;

    @Test
    public void test() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor executor =new ThreadPoolExecutor(corePoolSize,maximumPoolSize,1L, TimeUnit.MILLISECONDS,workQueue);
        //执行任务，未达到核心线程数之前，创建线程
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        //核心线程满了，阻塞队列未满，任务添加到队列中
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        //阻塞队列满了，任务未达到最大线程数
        executor.execute(new TestTask());
        executor.execute(new TestTask());
        //任务大于最大线程数,执行拒绝策略
        executor.execute(new TestTask());
    }
}

class TestTask implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}