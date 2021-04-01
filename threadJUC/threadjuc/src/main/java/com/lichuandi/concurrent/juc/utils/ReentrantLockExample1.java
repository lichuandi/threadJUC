package com.lichuandi.concurrent.juc.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

public class ReentrantLockExample1
{
    private final Lock lock = new ReentrantLock();

    public void foo()
    {
        lock.lock();
        try
        {
            //...
        } finally
        {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {

        final ReentrantLock lock = new ReentrantLock();
        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.println(currentThread() + " acquired the lock.");
                assert lock.getHoldCount() == 1;
                TimeUnit.MINUTES.sleep(2);
                lock.lock();
                System.out.println(currentThread() + " acquired the lock again.");
                assert lock.getHoldCount() == 2;
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
                System.out.println(currentThread() + " released the lock.");
                assert lock.getHoldCount() == 1;
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        lock.lock();
        System.out.println("main thread acquired the lock");
        lock.unlock();
        System.out.println("main thread released the lock");
    }
}