package com.lichuandi.reflect.test02;
//作为一个父类
public class Person {
    //属性
    private int age;
    public String name;

    //方法
    private void eat(){
        System.out.println("Person---eat");
    }
    public void sleep(){
        System.out.println("Person---sleep");
    }
}
