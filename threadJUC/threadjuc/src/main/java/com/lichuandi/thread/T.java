package com.lichuandi.thread;

/**
 * @Auther digege
 * @Date 2021/2/23
 * @Description：com.lichuandi.thread version：
 */
public class T {

    private int count = 10;
    private Object o = new Object();
    public void m() {
        synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
        new T().m();
        Integer integer=300;//-128-127
        Integer integer2=300;//-128-127
        System.out.println(integer==integer2);
        System.out.println(integer.equals(integer2));
        Integer.signum(integer);
        System.out.println(Integer.signum(2));
    }

}