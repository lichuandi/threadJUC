package com.lichuandi.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadlocal version：1
 */
public class ThreadLocal2 {
   // volatile static  Person p=new Person();
    static  ThreadLocal<Person> t1=new ThreadLocal<>();
    public static void main(String[] args) {
        new  Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t1.get());
        }).start();
        new  Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.set(new Person());
        }).start();
    }
}

/*
class Person{
    String name="lichuandi";
}*/
