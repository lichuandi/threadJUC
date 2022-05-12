package com.lichuandi.jdk8.optionals;

import java.util.Optional;

/**
 * @author lichu
 * @auther digege
 * @Date 2021/5/17
 * @Description：
 * @page com.lichuandi.jdk8
 * version：1
 */

public class OptionalDemo {
    public static void main(String[] args){

    OptionalDemo optionalDemo = new OptionalDemo();
    Integer value1 = null;
    Integer value2 = new Integer(10);

    // Optional.ofNullable - 允许传递为 null 参数(可以为null的意思)
    Optional<Integer> a = Optional.ofNullable(value1);

    // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
      Optional<Integer> b = Optional.of(value2);
      System.out.println(optionalDemo.sum(a,b));
}

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在（是否存在的意思）如果存在返回True，不存在为false

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值（意思或是是，如果有值则返回其值，如果没有返回指定的值）
        Integer value1 = a.orElse(new Integer(0));


        //Optional.get - 获取值，值需要存在（获取Optional的值，必须有值，否则抛出NoSuchElementException）
        Integer value2 = b.get();
        return value1 + value2;

  }
}
