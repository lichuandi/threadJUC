package com.lichuandi.jdk8.myjava8.lambdarun;

/**
 * @author digege
 * @date 2022/1/21 23:54
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.lambdarun
 * version：1
 */
public class RunnableDemo {
    public static void  startThread(Runnable runnable) {
        // 开启动线程
        new Thread(runnable).start();
    }

    public static void main(String[] args) {

        startThread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"--->" +"线程启动");
                    }
                });
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"--->" +"线程启动");
        });
    }
}
