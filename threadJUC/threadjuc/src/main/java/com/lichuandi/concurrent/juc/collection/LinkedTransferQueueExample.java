package com.lichuandi.concurrent.juc.collection;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueExample
{
    public static void main(String[] args) throws InterruptedException
    {
        getWaitingConsumerCount();
    }

    private static void getWaitingConsumerCount() throws InterruptedException
    {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        for (int i = 0; i < 3; i++)
        {
            new Thread(() ->
            {
                try
                {
                    System.out.println(queue.take());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " consume data over.");
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        assert queue.hasWaitingConsumer();
        assert queue.getWaitingConsumerCount() == 3;
        queue.offer("test");
        assert queue.hasWaitingConsumer();
        assert queue.getWaitingConsumerCount() == 2;
    }

    private static void tryTransferWithTimeout() throws InterruptedException
    {
        final LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        queue.add("hello");
        queue.offer("world");
        new Thread(() ->
        {
            try
            {
                assert queue.tryTransfer("Alex", 3, TimeUnit.SECONDS);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("current thread exit.");
        }).start();
        TimeUnit.SECONDS.sleep(2);
        assert queue.take().equals("hello");
        assert queue.take().equals("world");
        assert queue.take().equals("Alex");
    }

    private static void tryTransfer() throws InterruptedException
    {
        final LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        queue.add("hello");
        queue.offer("world");
        new Thread(() ->
        {
            assert !queue.tryTransfer("Alex");
            System.out.println("current thread exit.");
        }).start();
        TimeUnit.SECONDS.sleep(2);
        assert queue.size() == 2;
    }

    private static void transfer() throws InterruptedException
    {
        final LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        queue.add("hello");
        queue.offer("world");
        queue.put("Java");
        new Thread(() ->
        {
            try
            {
                queue.transfer("Alex");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("current thread exit.");
        }).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(queue.take());
        queue.put("Scala");
        System.out.println(queue.poll());
        System.out.println(queue.take());

        System.out.println(queue.take());
    }
}