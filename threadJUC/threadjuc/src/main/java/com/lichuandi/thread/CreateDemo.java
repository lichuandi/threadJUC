package com.lichuandi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author digege
 * @date 2021/11/28 23:42
 * @description：TODO
 * @page com.lichuandi.thread
 * version：1
 */
public class CreateDemo
{

    public static final int MAX_TURN = 5;


    static int threadNo = 1;

    static class DemoThread extends Thread
    {
//ExecutorService
        public DemoThread()
        {
            super("Mall-" + threadNo++);
        }

        @Override
        public void run()
        {
            for (int i = 1; i < MAX_TURN; i++)
            {
               // Print.cfo(getName() + ", 轮次：" + i);
                System.out.println(getName() + ", 轮次：" + i);
            }
        //    Print.cfo(getName() + " 运行结束.");
      System.out.println(getName() + " 运行结束.");
        }
    }


    public static void main(String args[]) throws InterruptedException
    {

        Thread thread = null;
        //方法一：使用Thread子类创建和启动线程
        for (int i = 0; i < 2; i++)
        {
            thread = new DemoThread();
            thread.start();
        }

       // Print.cfo(getCurThreadName() + " 运行结束.");
        System.out.println(Thread.currentThread().getName() + " 运行结束.");

    }
}