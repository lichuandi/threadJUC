package com.lichuandi.concurrent.juc.utils;

import java.util.concurrent.Phaser;

public class PhaserExample4
{
    public static void main(String[] args)
            throws InterruptedException
    {
        final Phaser phaser = new Phaser(2)
        {
            @Override
            protected boolean onAdvance(int phase, int registeredParties)
            {
                return phase >= 1;
            }
        };
        phaser.arrive();
        phaser.arrive();
        assert phaser.getPhase() == 1 : "so far, the phase number is 1.";
        assert !phaser.isTerminated() : "phaser is not terminated.";

        phaser.arrive();
        phaser.arrive();
        assert phaser.getPhase() < 0 : "so far, the phase number is negative value.";
        assert phaser.isTerminated() : "phaser is terminated now.";

        //invoke below method will not work.
        phaser.arriveAndAwaitAdvance();
    }
}