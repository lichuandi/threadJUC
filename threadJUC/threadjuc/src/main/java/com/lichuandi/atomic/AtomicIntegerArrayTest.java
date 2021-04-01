package com.lichuandi.atomic;

/**
 * @Auther digege
 * @Date 2021/1/13
 * @Description：com.lichuandi.atomic version：1
 */
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    static int[] valueArr = new int[] { 1, 2 };

    //AtomicIntegerArray内部会拷贝一份数组
    static AtomicIntegerArray ai = new AtomicIntegerArray(valueArr);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        //不会修改原始数组value
        System.out.println(ai.get(0));
        System.out.println(valueArr[0]);
    }

}