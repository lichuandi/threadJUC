package com.lichuandi.concurrent.thread.chapter04;


public class SynchronizedBasic
{


    private final Object MUTEX = new Object();

    public void sync()
    {
        synchronized (MUTEX)
        {

        }
    }


    public synchronized static void staticSync()
    {

    }


}
