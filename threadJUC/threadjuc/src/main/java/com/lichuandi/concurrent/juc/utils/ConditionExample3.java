package com.lichuandi.concurrent.juc.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

public class ConditionExample3
{
    public static void main(String[] args)
            throws InterruptedException
    {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                lock.lock();
                try
                {
                    condition.await();
                    System.out.println(currentThread().getName() + " is waked up.");
                    assert "0".equals(currentThread().getName());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } finally
                {
                    lock.unlock();
                }
            }, String.valueOf(i)).start();
            TimeUnit.SECONDS.sleep(1);
        }

        TimeUnit.SECONDS.sleep(15);
        lock.lock();
        try
        {
            condition.signal();
        } finally
        {
            lock.unlock();
        }
    }
}