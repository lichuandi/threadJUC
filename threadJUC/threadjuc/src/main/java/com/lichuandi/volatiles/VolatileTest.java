package com.lichuandi.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.volatiles version：
 */
public class VolatileTest {
    boolean runing=true;
 // volatile   boolean runing=true;
    void m(){
        System.out.println("M 开始");
        while (runing){

        }
        System.out.println("end 结束");
    }

    public static void main(String[] args) {
        VolatileTest volatileTest= new VolatileTest();
        new Thread(volatileTest::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.runing =false;
    }
}
