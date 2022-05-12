package com.lichuandi.fan;

import org.apache.hadoop.util.hash.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther digege
 * @Date 2021/6/21
 * @Description：
 * @page com.lichuandi.fan
 * version：1
 */
public class MYSet {
  public static void main(String[] args) {
    //
      Set<String> strings = new HashSet<>();
      strings.add("B");
      strings.add("B");
      strings.add("B");
      strings.add("A");
      if (strings.size()==1&&strings.contains("A")){
      System.out.println("所有的都是A");
      }else{
      System.out.println("所有的不是A");
      }
  }
}
