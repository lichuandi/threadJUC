package com.lichuandi.jdk8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther digege
 * @Date 2021/6/25
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class Streams {
  public static void main(String[] args) {

      List<Integer> list  =  new ArrayList<>();
      for (int j = 0; j < 1000; j++) {
          list.add(j);
      }
      //list.parallelStream().forEach(value -> {
    /*  list.stream().forEach(value -> {
          System.out.println(value);
      });*/
    //会产生问题
      System.out.println("最开始生成的集合长度:"+list.size());
      //parallelStream遍历数据的时候会产生丢失的问题
      for (int i = 0; i < 10 ; i++) {

          List<Integer> parseList = new ArrayList<>();
          list.parallelStream().forEach(integer -> {
              parseList.add(integer);
          });
          System.out.println("每次遍历的集合长度:"+ parseList.size());
      }
      //不会产生问题
      //parallelStream遍历数据的时候会产生丢失的问题
      for (int i = 0; i < 10 ; i++) {

          List<Integer> parseList = new ArrayList<>();
          List<Integer> synchronizedList = Collections.synchronizedList(parseList);
          list.parallelStream().forEach(integer -> {
              synchronizedList.add(integer);
          });
          System.out.println("每次遍历的集合长度:"+ synchronizedList.size());
      }

  }
}
