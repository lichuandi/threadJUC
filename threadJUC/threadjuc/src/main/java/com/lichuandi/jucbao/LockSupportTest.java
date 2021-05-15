package com.lichuandi.jucbao;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.jucbao version：1
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==5){
                    //使用Lockasupport的park方法堵塞当前线程t
                    LockSupport.park();
                }

                if (i==8){
                    //令牌unpark主线程使用一次，已经失效了
                    LockSupport.park();
                }
            }

            try {
                //1s
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t.start();
        //唤起线程
        LockSupport.unpark(t);
        //LockSupport.unpark(t);
    }
}
