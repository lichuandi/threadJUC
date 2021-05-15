package com.lichuandi.threadlocal;

import com.lichuandi.thread.T;

import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/5/7
 * @Description：com.lichuandi.threadlocal version：1
 */
public class Profiler {
    public static void main(String[] args) throws InterruptedException {
    Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:"+Profiler.end()+"ms");
    }
    private static  final  ThreadLocal<Long> TIME_THREADLOCAL=new ThreadLocal<Long>(){
        protected  Long initiaValue(){
            return System.currentTimeMillis();
        }
    };
    public static  final  void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static  final  long end(){

        return  System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }
}
