package com.lichuandi.jdk8.myjava8.consumer;

import com.google.inject.internal.cglib.reflect.$FastMethod;

import java.util.function.Consumer;

/**
 * @author digege
 * @date 2022/1/23 0:30
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.consumer
 * version：1
 */
public class ConsumerDemo {
    public static  void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }
    public static void main(String[] args) {
    // 使用Consumer,定义一个字符串，消费一个字符串
    method(
        "digege",
        (String name) -> System.out.println(name));

    // 翻转
    method(
        "digege",
        (String name) -> {
          // 字符串翻转
          System.out.println(new StringBuffer(name).reverse().toString());
        });
    }

}
