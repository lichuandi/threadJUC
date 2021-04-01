package com.lichuandi.atomic;

/**
 * @Auther digege
 * @Date 2021/1/13
 * @Description：com.lichuandi.atomic version：1
 */
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        //相当于i++,返回的是旧值,看方法名就知道，先获取再自增
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        //先自增，再获取
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.get());
        //增加一个指定值，先add，再get
        System.out.println(ai.addAndGet(5));
        System.out.println(ai.get());
        //增加一个指定值,先get，再set
        System.out.println(ai.getAndSet(5));
        System.out.println(ai.get());
    }

}