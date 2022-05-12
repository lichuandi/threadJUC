package com.lichuandi.annotation.mytest;

import java.util.Date;

/**
 * @Auther digege
 * @Date 2021/6/6
 * @Description：
 * @page com.lichuandi.annotation.mytest
 * version：1
 */
public class SuppressWarningTest {

    @SuppressWarnings(value={"deprecation"})
    public static void doSomething(){
        Date date = new Date(113, 8, 26);
        System.out.println(date);
    }

    public static void main(String[] args) {
        doSomething();
    }
}