package com.lichuandi.hutool;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther digege @Date 2021/5/17 @Description：
 *
 * @page com.lichuandi.hutool version：1
 */
public class HutoolDate {
  public static void main(String[] args) {
    // 当前时间
    Date date = DateUtil.date();
    // 当前时间
    Date date2 = DateUtil.date(Calendar.getInstance());
    // 当前时间
    Date date3 = DateUtil.date(System.currentTimeMillis());
    // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
    String now = DateUtil.now();
    // 当前日期字符串，格式：yyyy-MM-dd
    String today = DateUtil.today();
    //字符串转为日期
    String datestr="2020-09-11";
    DateTime dateTime = DateUtil.parse(datestr);
    DateTime dateTimeFormat = DateUtil.parse(datestr,"yyyy-MM-dd");
    //格式化日期输出
    String format = DateUtil.format(dateTime, "yyyy/MM/dd");
    String formatDate = DateUtil.formatDate(dateTime);
    String formatDateTime = DateUtil.formatDateTime(dateTime);
    String formatTime = DateUtil.formatTime(dateTime);//结果：00:00:00
    //获得年的部分
    DateUtil.year(date);
//获得月份，从0开始计数
    DateUtil.month(date);
//获得月份枚举
    DateUtil.monthEnum(date);
    String dateStr = "2017-03-01 22:33:23";
    Date dateBe = DateUtil.parse(dateStr);

//一天的开始，结果：2017-03-01 00:00:00
    Date beginOfDay = DateUtil.beginOfDay(dateBe);

//一天的结束，结果：2017-03-01 23:59:59
    Date endOfDay = DateUtil.endOfDay(dateBe);
    //日期和时间偏移
    DateUtil.offset(dateBe, DateField.MONTH,2);
    DateUtil.offsetDay(dateBe, 2);
    DateUtil.offsetHour(dateBe, -2);
//昨天
    DateUtil.yesterday();
//明天
    DateUtil.tomorrow();
//上周
    DateUtil.lastWeek();
//下周
    DateUtil.nextWeek();
//上个月
    DateUtil.lastMonth();
//下个月
    DateUtil.nextMonth();
    String dateStr1 = "2017-03-01 22:33:23";
    Date date1 = DateUtil.parse(dateStr1);

    String dateStr2 = "2017-04-01 23:33:23";
    Date date22 = DateUtil.parse(dateStr2);

//相差一个月，31天
    long betweenDay = DateUtil.between(date1, date22, DateUnit.DAY);

//Level.MINUTE表示精确到分
    String formatBetween = DateUtil.formatBetween(betweenDay, BetweenFormatter.Level.MINUTE);
//输出：31天1小时

    Console.log(formatBetween);
    //计时
    TimeInterval timer = DateUtil.timer();

//---------------------------------
//-------这是执行过程
//---------------------------------

    timer.interval();//花费毫秒数
    timer.intervalRestart();//返回花费时间，并重置开始时间
    timer.intervalMinute();//花费分钟数
    //星座和属相
    // "摩羯座"
    String zodiac = DateUtil.getZodiac(Month.JANUARY.getValue(), 19);

// "狗"
    String chineseZodiac = DateUtil.getChineseZodiac(1994);


//年龄
    DateUtil.ageOfNow("1990-01-30");

//是否闰年
    DateUtil.isLeapYear(2017);


  }
}
