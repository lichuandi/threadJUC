package com.lichuandi.concurrent.juc.utils;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class PhaserExample1
{
    public static void main(String[] args) throws InterruptedException
    {
        final Phaser phaser = new Phaser();
        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                phaser.register();
                try
                {
                    TimeUnit.SECONDS.sleep(current().nextInt(20));
                    int arriveId = phaser.arrive();
                    System.out.println(new Date() + ":" + currentThread() + " completed the work. arriveId:" + arriveId + ",phaser Number:" + phaser.getPhase());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }, "T-" + i).start();
        }

        TimeUnit.SECONDS.sleep(2);
        phaser.register();
        int arriveId = phaser.arriveAndAwaitAdvance();
        assert phaser.getRegisteredParties() == 11 : "total 11 parties is registered.";
        System.out.println(new Date() + ": all of sub task completed work. arriveId:" + arriveId + ",phaser Number:" + phaser.getPhase());
    }
}
