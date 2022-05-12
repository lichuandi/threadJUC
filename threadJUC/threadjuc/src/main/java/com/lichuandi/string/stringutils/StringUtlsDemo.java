package com.lichuandi.string.stringutils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @Auther digege
 * @Date 2021/5/25
 * @Description：
 * @page com.lichuandi.string.stringutils
 * version：
 */
@Slf4j
public class StringUtlsDemo extends StringUtils {
  public static void main(String[] args) {
      StringUtlsDemo stringUtlsDemo = new StringUtlsDemo();
    //  stringUtlsDemo.
    System.out.println(StringUtlsDemo.isEmpty(stringUtlsDemo));
      String s = new String("123");
    System.out.println(StringUtlsDemo.isEmpty(s));
    System.out.println(Optional.of(s));
  }
}
