package com.lichuandi.string;

/**
 * @Auther digege
 * @Date 2021/4/27
 * @Description：com.lichuandi.string version：1
 */
public class StringDemo {
    public static void main(String[] args) {
        String str="abc";
        System.out.println(str);

        String s = new String();
        String s2 = new String("abc");
        String s3 = new String(new char[]{'a','b','c'});
        String s4="abc";
        System.out.println(str==s4);
        System.out.println(s4.length());
        String s5= new String();
        System.out.println(s5.isEmpty());
        String s6= new String("abc");
        System.out.println(s6.charAt(1));

        String s7= new String("abc");

        String s77= new String("abc");
        //当两个对象的地址指向相同时候，直接返回ture2当自己根自己比较直接ture
        System.out.println(s7.equals(s77));//把s77转string，先比长度，不一样false
        System.out.println(s7==s2);
        String s8= new String("abc");

        String s9= new String("abc");
        System.out.println(s8.compareTo(s9));//s8和s9转为char数组v1和v2 如abc，abcdf 则s8-s9的长度3-6=-3如果abc和afc则返回b和f的ascll
        String s10="abcdefgh";
        System.out.println(s10.substring(3));
        System.out.println(s10.substring(3,6));
        System.out.println(s10.concat("pppp"));
        String s11="abcdefgh";
        System.out.println(s11.replace("a","u"));
        String s12="a-b-c-d-e-f";
        String[] strings=s12.split("-");
        System.out.println(strings);
        String s13="abc";
        System.out.println(s13.toUpperCase().toUpperCase());
        String s14="  abc  ";
        System.out.println(s14.trim());
        String s15="abc";
        System.out.println(s15.toString());
        System.out.println(s15.indexOf(111));

        String ss1="abc";
        String ss2="ab"+"c";
        String ss3="a"+"b"+"c";

        System.out.println(ss1==ss2);//栈中的ss1指向常量池abc，ss2也指向常量池因为abc已经存在了
        System.out.println(ss3==ss2);
        System.out.println(ss1==ss3);
        String ss0=new String("abc");//ss0指向堆中的对象value，而value指向常量池abc
        String ss4="abc";//ss4为abc，但是ss4在编译时候不知道ss1是abc。
        String ss5=ss4+"def";//有变量拼接的  所以并不会直接合并abcdef
        String ss6="abcdef";

        System.out.println(ss5);
        System.out.println(ss6==ss5);
        System.out.println(ss6.equals(ss5));

    }
}
