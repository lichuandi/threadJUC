package com.lichuandi.threadpool;

import com.google.inject.internal.cglib.core.$Signature;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadpool version：1
 */
public class FixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long st = System.currentTimeMillis();
        getProme(1,200000);
        long end = System.currentTimeMillis();
        System.out.println(end-st);
        final  int cpu=4;
        ExecutorService service = Executors.newFixedThreadPool(cpu);
        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 =new MyTask(80001,130000);
        MyTask t3=new MyTask(130001,170000);
        MyTask t4=new MyTask(170001,200000);
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> submit = service.submit(t2);
        Future<List<Integer>> submit1 = service.submit(t3);
        Future<List<Integer>> submit2 = service.submit(t4);
         st = System.currentTimeMillis();
       f1.get();
       submit.get();
       submit1.get();
       submit2.get();
        end = System.currentTimeMillis();
        System.out.println(end-st);
    }

    static  class MyTask implements Callable<List<Integer>>{
        int startPos,endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {

            return null;
        }

    }
    static boolean isprime(int num){
        for (int i = 2; i <=num/2 ; i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getProme(int s,int e){
        List<Integer> list = new ArrayList<>();
        for (int i = s; i <=e ; i++) {
            if (isprime(i)){
                list.add(i);
            }
        }
        return list;
    }


}

