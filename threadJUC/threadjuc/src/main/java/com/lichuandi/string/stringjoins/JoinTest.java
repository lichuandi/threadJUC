package com.lichuandi.string.stringjoins;

import java.util.StringJoiner;

/**
 * @Auther digege
 * @Date 2021/7/5
 * @Description：
 * @page com.lichuandi.string.stringjoins
 * version：1
 */
public class JoinTest {
  public static void main(String[] args) {
      String s="abc";
      String s2="cde";
      StringJoiner add = new StringJoiner(".").add(s).add(s2);
      System.out.println(add);
      StringJoiner me = new StringJoiner(".").add(s).add(s2).merge(add);

      System.out.println(me);
    //
     int MIN_VALUE = 0x80000000;
      long MIN_VALUE2 = 0x8000000000000000L;
    System.out.println(MIN_VALUE);
    System.out.println(MIN_VALUE2);
  }
}
