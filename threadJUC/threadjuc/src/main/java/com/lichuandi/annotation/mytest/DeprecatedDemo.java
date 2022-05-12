package com.lichuandi.annotation.mytest;

import com.lichuandi.annotation.myAnno.DeprecatedTest;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther digege
 * @Date 2021/6/6
 * @Description：
 * @page com.lichuandi.annotation.mytest
 * version：1
 */
public class DeprecatedDemo {
    //@Deprecated
    @DeprecatedTest
    private static void getString(){
    System.out.println("我不可用了");
    }
    private static void getString2(){
    System.out.println("我不可用了2");
    }
    // Date是日期/时间类。java已经不建议使用该类了
    private static void testDate() {
        Date date = new Date(113, 8, 25);
        System.out.println(date.getYear());
    }
    // Calendar是日期/时间类。java建议使用Calendar取代Date表示"日期/时间"
    private static void testCalendar() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
    }
  public static void main(String[] args) {
    getString();
      getString2();
      testDate();
      testCalendar();
  }
}
