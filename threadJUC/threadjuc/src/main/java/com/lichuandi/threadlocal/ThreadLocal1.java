package com.lichuandi.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.threadlocal version：1
 */
public class ThreadLocal1 {
    volatile static  Person p=new Person();
    public static void main(String[] args) {
        new  Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();
        new  Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name="digege";
        }).start();
    }
}
class Person{
    String name="lichuandi";
}