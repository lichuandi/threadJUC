package com.lichuandi.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;

import java.util.Date;

/**
 * @Auther digege
 * @Date 2021/5/17
 * @Description：
 * @page com.lichuandi.hutool
 * version：1
 */
public class HutoolDateTime {
  public static void main(String[] args) {
    //
      Date date = new Date();

//new方式创建
      DateTime time = new DateTime(date);
      Console.log(time);

//of方式创建
      DateTime now = DateTime.now();
      DateTime dt = DateTime.of(date);
      DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);

//默认情况下DateTime为可变对象，此时offset == dateTime
      DateTime offset = dateTime.offset(DateField.YEAR, 0);

//设置为不可变对象后变动将返回新对象，此时offset != dateTime
      dateTime.setMutable(false);
      offset = dateTime.offset(DateField.YEAR, 0);
      DateTime dateTime2 = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
//结果：2017-01-05 12:34:23
      String dateStr = dateTime2.toString();

//结果：2017/01/05


  }
}
