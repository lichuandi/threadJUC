package com.lichuandi.concurrent.juc.utils;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class PhaserExample3
{
    public static void main(String[] args)
            throws InterruptedException
    {
        final Phaser phaser = new MyPhaser(() ->
                System.out.println(new Date() + ": all of sub task completed work.")
        );

        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                phaser.register();
                try
                {
                    TimeUnit.SECONDS.sleep(current().nextInt(20));
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(new Date() + ":" + currentThread() + " completed the work.");
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }, "T-" + i).start();
        }
    }

    private static class MyPhaser extends Phaser
    {
        private final Runnable runnable;

        private MyPhaser(Runnable runnable)
        {
            super();
            this.runnable = runnable;
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties)
        {
            this.runnable.run();
            return super.onAdvance(phase, registeredParties);
        }
    }
}