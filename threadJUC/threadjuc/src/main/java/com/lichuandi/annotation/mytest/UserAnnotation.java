package com.lichuandi.annotation.mytest;

/**
 * @Auther digege
 * @Date 2021/6/6
 * @Description：
 * @page com.lichuandi.annotation.mytest
 * version：1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@UserAnnotation.TestA    //使用了类注解
public class UserAnnotation {

    @TestA //使用了类成员注解
    private Integer age;

    @TestA //使用了构造方法注解
    public UserAnnotation(){

    }
    @TestA //使用了类方法注解
    public void a(){
        @TestA //使用了局部变量注解
                Map m = new HashMap(0);
    }

    public void b(@TestA Integer a){ //使用了方法参数注解

    }

    //@Target(ElementType.PACKAGE)//第一个元注解Target放在那里目标，

    public static @interface TestA {
    //这里定义了一个空的注解，它能干什么呢。我也不知道，但他能用。
    }
}
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestB {
    //这里定义了一个空的注解，它能干什么呢。我也不知道，但他能用。
}

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface TestC {
    //这里定义了一个空的注解，它能干什么呢。我也不知道，但他能用。
  String name();
  int id() ;
  Class gid();
}