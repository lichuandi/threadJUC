package com.lichuandi.jdk8.collectors;

import lombok.Data;

/**
 * @Auther digege
 * @Date 2021/5/28
 * @Description：
 * @page com.lichuandi.jdk8.collectors
 * version：1
 */
//求职者的实体类
    @Data
public class Person {
    private String name;//姓名
    private Integer age;//年龄
    private String gender;//性别

   /* public Person(String 张三, int i, String 男) {
    }*/

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //重写toString，方便观看结果
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
