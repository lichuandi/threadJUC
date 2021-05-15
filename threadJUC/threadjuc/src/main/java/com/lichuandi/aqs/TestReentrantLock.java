package com.lichuandi.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.aqs version：
 */
public class TestReentrantLock {
    private  static  volatile  int i=0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        synchronized (TestReentrantLock.class){
            i++;
        }
        lock.unlock();

    }
}
