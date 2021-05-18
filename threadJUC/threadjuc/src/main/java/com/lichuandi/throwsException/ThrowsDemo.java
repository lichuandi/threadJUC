package com.lichuandi.throwsException;

/**
 * @Auther digege @Date 2021/5/15 @Description：
 *
 * @page com.lichuandi.throwsException version：1
 */
public class ThrowsDemo {
  public static void main(String[] args) {
    try {
      //throw将产生异常抛出可以是异常引用也可以是异常对象 一般是方法体内
      throw new Exception("抛出异常");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("捕获异常");
    }
  }
}
