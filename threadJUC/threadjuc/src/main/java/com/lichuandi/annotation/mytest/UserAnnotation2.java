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


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;


@TestA(name="type",gid=Long.class) //类成员注解
public class UserAnnotation2 {
    @TestA(name="param",id=1,gid=Long.class) //类成员注解
    private Integer age;
    @TestA (name="construct",id=2,gid=Long.class)//构造方法注解
    public UserAnnotation2(){
    }
    @TestA(name="public method",id=3,gid=Long.class) //类方法注解
    public void a(){
        Map m = new HashMap(0);
    }
    @TestA(name="protected method",id=4,gid=Long.class) //类方法注解
    protected void b(){
        Map m = new HashMap(0);
    }
    @TestA(name="private method",id=5,gid=Long.class) //类方法注解
    private void c(){
        Map m = new HashMap(0);
    }
    public void b(Integer a){
    }
}
@Target(value = {ElementType.TYPE, METHOD, FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
 @interface TestA {
    String name();
    int id() default 0;
    Class gid();
}