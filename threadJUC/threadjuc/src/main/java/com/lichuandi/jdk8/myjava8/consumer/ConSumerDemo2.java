package com.lichuandi.jdk8.myjava8.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author digege
 * @date 2022/1/23 0:43
 * @description：两个consumer接口，组合
 * ConSumer<String> con1
 * ConSumer<String> con2
 * String s= "hello";
 * con1.accept(s)
 * con2.accept(s)
 * 等同于 con1.andThen(con2).accept(s)
 * @page com.lichuandi.jdk8.myjava8.consumer
 * version：1
 */
public class ConSumerDemo2 {
    public static  void method(String s, Consumer<String> con1, Consumer<String> con2){
        con1.accept(s);
        con2.accept(s);
        // 等同
        //con1.andThen(con2).accept(s);
    }
    public static void main(String[] args) {

    method(
        "Hello",
            (t) -> {
            System.out.println(t.toUpperCase());
            },
            (t) -> {
                System.out.println(t.toLowerCase());
            }
            );
        List<Object> objects = new ArrayList<>();
        objects.add(11);
        objects.add("ab");
        Optional<Object> o1 = Optional.ofNullable(objects);
        o1.ifPresent(s -> System.out.println(s));
    }

}
