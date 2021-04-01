package com.lichuandi.conrrent;

import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/2/25
 * @Description：com.lichuandi.conrrent version：1
 */
public class DuplicatedStartThread
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.start();
    }
}
