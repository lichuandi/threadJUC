package com.lichuandi.juc2021;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lichu @Auther digege @Date 2021/8/21 @Description：
 * @page com.lichuandi.juc2021 version：1
 */
public class CreateThreadTest {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 第一种
    new ThreadTest().start();
    // 第二种
    new Thread(new RunnableTest(), "runable").start();
    // 第三种 有返回值
    // 创建Callable实例
    CallableTest callableTest = new CallableTest();
    //  Callable callable;
    // 使用FutureTask包装callable对象，FutureTask是包装器，接受callable对象，实现了runnable和Future
    FutureTask<Integer> futureTask = new FutureTask<Integer>(callableTest);
    // FutureTask对象是thread对象的target目标创建并启动线程
    new Thread(futureTask, "有返回值的线程").start();
    // 获取子线程执行结束后返回值
    // futureTask.get();
    System.out.println(futureTask.get());
  }

  static class ThreadTest extends Thread {
    @Override
    public void run() {
      System.out.println("hello digege");
    }
  }

  static class RunnableTest implements Runnable {

    @Override
    public void run() {
      System.out.println("hello digege");
    }
  }

  static class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      // System.out.println("hello digege");
      return 1;
    }
  }
}
