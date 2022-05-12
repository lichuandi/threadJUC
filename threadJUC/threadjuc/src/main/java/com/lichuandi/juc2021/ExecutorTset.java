package com.lichuandi.juc2021;

import cn.hutool.cache.Cache;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @auther digege
 * @date 2021/8/21
 * @description：
 * @page com.lichuandi.juc2021
 * version：1
 */
public class ExecutorTset {
  public static void main(String[] args)  throws Exception{
    //
      ExecutorService threadPool = Executors.newFixedThreadPool(10);
    ArrayList<Callable<Integer>> callable = Lists.newArrayList(
            new Callable<Integer>() {
              @Override
              public Integer call() throws Exception {
                  System.out.println("1");
                return 1;
              }
            }, new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println("2");
                        return 2;
                    }
                });
      List<Future<Integer>> futures = threadPool.invokeAll(callable);

  }
}
