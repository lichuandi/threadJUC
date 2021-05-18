package com.lichuandi.hutool;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

/**
 * @Auther digege
 * @Date 2021/5/17
 * @Description：
 * @page com.lichuandi.hutool
 * version：1
 */
public class HutoolChineseDate {
  public static void main(String[] args) {
      //通过农历构建
      ChineseDate chineseDate = new ChineseDate(1992,12,14);
      //通过公历构建
      ChineseDate chineseDate2 = new ChineseDate(DateUtil.parseDate("1993-01-06"));
//通过公历构建
      ChineseDate date = new ChineseDate(DateUtil.parseDate("2020-01-25"));
// 一月
      date.getChineseMonth();
// 正月
      date.getChineseMonthName();
// 初一
      date.getChineseDay();
// 庚子
      date.getCyclical();
// 生肖：鼠
      date.getChineseZodiac();
// 传统节日（部分支持，逗号分隔）：春节
      date.getFestivals();
// 庚子鼠年 正月初一
      date.toString();
//通过公历构建
      ChineseDate chineseDate3 = new ChineseDate(DateUtil.parseDate("2020-08-28"));

// 庚子年甲申月癸卯日  5.4.1开始
      String cyclicalYMD = chineseDate3.getCyclicalYMD();

  }
}
