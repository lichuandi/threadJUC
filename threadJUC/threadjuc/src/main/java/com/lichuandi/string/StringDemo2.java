package com.lichuandi.string;

/**
 * @Auther digege
 * @Date 2021/4/28
 * @Description：com.lichuandi.string version：1
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String ss1="abc";
        String ss2=ss1+"def";
        System.out.println(ss2);
        String ss3="abc";
        String ss4=ss3;
        System.out.println(ss3.hashCode());
        System.out.println(ss4.hashCode());
        ss3="abcdef";
        System.out.println(ss3.hashCode());
        System.out.println(ss3==ss4);

    }
}
