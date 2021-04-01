package com.lichuandi.concurrent.juc.collection;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample
{
    public static void main(String[] args)
    {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(2);
        assert queue.remainingCapacity() == 0x7fffffff;
        queue.offer(1);
        queue.offer(10);
        queue.offer(14);
        queue.offer(3);

        assert queue.size() == 4;

        assert queue.poll() == 1;
        assert queue.poll() == 3;
        assert queue.poll() == 10;
        assert queue.poll() == 14;

    }
}
