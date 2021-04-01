package com.lichuandi.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockDemo {
    private Lock lock=new ReentrantLock();
    //Lock lock=new ReentrantLock(True)//公平锁
    //Lock lock=new ReentrantLock(false)//非公平锁
    private Condition condition=lock.newCondition();//创建condition条件
    public  void  testMethod(){
        try {
            lock.lock();//lock加锁
            //1wait方法等待
            //System.out.println("开始wait");
            condition.await();
            //通过创建Condition对象来使线程wait，必须先执行lock.lock方法获得锁
           //2方法唤醒
            condition.signal();
            //通过创建condition对象来使线程
            for (int i=0;i<5;i++){
                System.out.println("ThreadName"+Thread.currentThread().getName()+(""+(i+1)));
            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
//常用的使用方式
class X {
    private final ReentrantLock lock = new ReentrantLock();
    // ...
    public void m() {
        lock.lock(); // block until condition holds
        try {
            // ... method body
        } finally {
            lock.unlock();
        }
    }
}