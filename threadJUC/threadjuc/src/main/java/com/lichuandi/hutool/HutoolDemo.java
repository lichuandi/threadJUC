package com.lichuandi.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;
import junit.framework.Assert;
import org.springframework.core.convert.converter.ConverterRegistry;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther digege
 * @Date 2021/5/17
 * @Description：
 * @page com.lichuandi.hutool
 * version：1
 */
public class HutoolDemo {
  public static void main(String[] args) {
    //toStr(Object obj) 转为字符串
      int a=1;
      String toStr = Convert.toStr(a);
    System.out.println(toStr);
      long[] b={1,2,3,4,5};
      String toStr1 = Convert.toStr(b);
    System.out.println(toStr1);
      String[] bstr={"1","2","3","4","5"};
      //结果为Integer数组
      Integer[] integers = Convert.toIntArray(bstr);
    System.out.println(integers);
      Integer[] integers1 = Convert.toIntArray(b);
    System.out.println(integers1);
      //转为日期
      String sdate="1987-09-11";
      Date date = Convert.toDate(sdate);
    System.out.println(date);
      //转为集合
      Object[] aList = {"a", "你", "好", "", 1};
      List<?> list = Convert.convert(List.class, aList);
      System.out.println(list);
    // 从4.1.11开始可以这么用
    // List<?> list = Convert.toList(a);
    // 其他类型转换convert(Class<T> type, Object value) new TypeReference<Object>() {
    //    }
    String convert = Convert.convert(new TypeReference<String>() {
    }, aList);
    //半角和全角
    String sbc="123456";
    String dbc="１２３４５６";
    String toSBC = Convert.toSBC(sbc);
    System.out.println(toSBC);
    String toDBC = Convert.toDBC(dbc);
    System.out.println(toDBC);
    //16进制Hex
    String ahex="我是李传第";
    String hex = Convert.toHex(ahex, CharsetUtil.CHARSET_UTF_8);
    System.out.println(hex);
    String shex = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
    System.out.println(shex);
    //UNIcode和字符串
    String toUnicode = Convert.strToUnicode(ahex);
    System.out.println(toUnicode);
    String unicodeToStr = Convert.unicodeToStr(toUnicode);
    System.out.println(unicodeToStr);
    //编码转换
    String aCharse = "我不是乱码";
   //转换后result为乱码
    String result = Convert.convertCharset(aCharse, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
    String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
    Assert.assertEquals(raw,a);
   // Assert.assertEqual(raw, a);
    //时间
    long aTime = 4535345;

//结果为：75
    long minutes = Convert.convertTime(aTime, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
  }
  //金额
  double aGit = 67556.32;

  //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
  String digitUppercase = Convert.digitToChinese(aGit);
  //包装类
  //去包装
  Class<?> wrapClass = Integer.class;

  //结果为：int.class
  Class<?> unWraped = Convert.unWrap(wrapClass);

  //包装
  Class<?> primitiveClass = long.class;

  //结果为：Long.class
  Class<?> wraped = Convert.wrap(primitiveClass);
  //自定义类型转换
  int anInt=12345;
  //ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
 // String result1 = converterRegistry.convert(String.class, anInt);
//Assert.assertEquals("12345", result1);
}
