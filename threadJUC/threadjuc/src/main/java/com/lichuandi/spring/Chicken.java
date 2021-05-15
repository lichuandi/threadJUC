package com.lichuandi.spring;

/**
 * @Auther digege
 * @Date 2021/4/26
 * @Description：com.lichuandi.spring version：1
 */
public class Chicken implements Animal {
    @Override
    public void say() {
        System.out.println("鸡你很美");
    }
}