package com.lichuandi.thread;

import lombok.SneakyThrows;

import java.io.File;

/**
 * @Auther digege
 * @Date 2021/2/3
 * @Description：com.lichuandi.thread version：1
 */

public class Test{
    @SneakyThrows
    public static  String fun1(String str){
        File file=new File("lili.txt");
      file.createNewFile();

        //方法一 将字符串转换为字符数组
        char[] arr = str.toCharArray();
        // 逆序输出字符数组
        for(int i = 0;i<arr.length/2;i++){
            char temp;
            temp = arr[i];
            arr[i] = arr[arr.length-i-1] ;
            arr[arr.length-i-1] = temp;
        }
        return new String(arr);
    }

    public static String fun2(String str){
        StringBuilder sb = new StringBuilder(str);
        return  sb.reverse().toString();
    }
    public static void main(String[] args){
        String str = "纵有红颜，百生千劫";
        System.out.println(fun1(str));
        System.out.println(fun2(str));
    }

}