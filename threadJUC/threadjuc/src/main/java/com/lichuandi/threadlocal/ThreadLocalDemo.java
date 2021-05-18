package com.lichuandi.threadlocal;

/**
 * @Auther digege
 * @Date 2021/5/18
 * @Description：
 * @page com.lichuandi.threadlocal
 * version：1
 */
import java.util.Locale;

public class ThreadLocalDemo {
    private static ThreadLocal<Integer> local=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;//初始值
        }
    };

    public static void main(String[] args) {
        Thread[] threads=new Thread[3];
        for(int i=0;i<3;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    int mun=local.get();
                    for(int j=0;j<10;j++){
                        mun=mun+1;
                    }
                    local.set(mun);
                    System.out.println(Thread.currentThread().getName()+"==="+local.get());

                }
            });
        }
        for(Thread t:threads){
            t.start();
        }

    }


}
/**
 * void set(Object value)设置当前线程的线程局部变量的值。
 *
 * <p>public Object get()该方法返回当前线程所对应的线程局部变量。
 *
 * <p>public void remove()将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK
 * 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
 *
 * <p>protected Object
 * initialValue()返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
 * ———————————————— 版权声明：本文为CSDN博主「好一个大布丁」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/baidu_23086307/article/details/56674454
 */
