package com.lichuandi.string;

import java.util.Objects;

/**
 * @Auther digege
 * @Date 2021/5/14
 * @Description：com.lichuandi.string version：1
 * 堆：存储new的对象;
 * 常量池：用来存储final static、String的常量。
 * Objects.equals与String.equals的区别
 * Objects.equals(==)：比较内存地址；
 * String.equals: 比较内容即可，不管内存地址。
 * 总结：
 * Objects.equals相等，String.equals一定相等；
 * String.equals相等，Object.equals不一定相等。
 */
public class ObjStrEqual {

    public static void main(String[] args) {
        String str1="lichaudi";
        String str2="lichaudi";
        String str3 = new String("lichaudi");
        String str4 = new String("lichaudi");
        //比较内存地址
        System.out.println(str1==str2);
        System.out.println(str1==str3);//false 内存地址不一样
        System.out.println(str4==str3);//false 内存地址不一样
        //比较内容 true  str1和str2放在常量池
        System.out.println(str1.equals(str2)); //内容一样
        System.out.println(str1.equals(str3)); //内容一样
        System.out.println(str3.equals(str4)); //内容一样
        //使用Objects 1.7以后才有的 true
        Objects.equals(str1,str2);
        /**
         *  public static boolean equals(Object a, Object b) {
         *         return (a == b) || (a != null && a.equals(b));
         *     }
         */
        System.out.println(Objects.equals(str1,str2));
        //true
        System.out.println(Objects.equals(str3,str4));
        System.out.println(Objects.equals(str2,str4));//ture
        System.out.println(Objects.hashCode(str1));//876898651
        System.out.println(Objects.hashCode(str2));//876898651
        System.out.println(Objects.hashCode(str3));//876898651
        System.out.println(Objects.hashCode(str4));//876898651
        System.out.println(str1.hashCode());//876898651
        System.out.println(str3.hashCode());//876898651
        System.out.println(str3.toCharArray());//lichuandi
        System.out.println(Objects.hash(str1));//876898682
        System.out.println(Objects.hash(str2));//876898682
        System.out.println(Objects.hash(str3));//876898682
        System.out.println(Objects.class);//
        System.out.println(Objects.nonNull(str1));//判断对象是否为null,不为返回true,否则返回false
        System.out.println(Objects.isNull(str1));//与non相反
        //检查对象obj不为null,如果为null,则抛出空指针异常,否则返回obj本身.
        //*可以判断对象是否是空对象.限制参数不能为空.
        System.out.println(Objects.requireNonNull(str1));  //lichaundi
        System.out.println(Objects.deepEquals(str1,str2));
        System.out.println(Objects.deepEquals(str1,str3));




    }
}
