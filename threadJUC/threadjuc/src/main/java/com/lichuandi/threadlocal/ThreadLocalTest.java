package com.lichuandi.threadlocal;

/**
 * @Auther digege
 * @Date 2021/5/18
 * @Description：
 * @page com.lichuandi.threadlocal
 * version：1
 */
public class ThreadLocalTest {
    static class MyThread extends Thread {
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                threadLocal.set(i);
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread();
        myThreadA.setName("ThreadA");

        MyThread myThreadB = new MyThread();
        myThreadB.setName("ThreadB");

        myThreadA.start();
        myThreadB.start();
    }

}
/**
 * 结果不一 ThreadA threadLocal.get() = 0 ThreadA threadLocal.get() = 1 ThreadA threadLocal.get() = 2
 * ThreadB threadLocal.get() = 0 ThreadB threadLocal.get() = 1 ThreadB threadLocal.get() = 2 或
 * ThreadB threadLocal.get() = 0 ThreadB threadLocal.get() = 1 ThreadB threadLocal.get() = 2 ThreadA
 * threadLocal.get() = 0 ThreadA threadLocal.get() = 1 ThreadA threadLocal.get() = 2
 *
 * 虽然两个线程都在向threadLocal对象中set()数据值，但每个线程都还是能取出自己设置的数据，确实可以达到隔离线程变量的效果。
 */
