package com.lichuandi.threadlocal;

/**
 * @Auther digege
 * @Date 2021/6/1
 * @Description：
 * @page com.lichuandi.threadlocal
 * version：1
 */
public class MyLocal2 {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final MyLocal2 test = new MyLocal2();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());//main

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
/*
1
main
12
Thread-0
1
main
 */