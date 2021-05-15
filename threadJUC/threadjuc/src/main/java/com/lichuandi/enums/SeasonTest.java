package com.lichuandi.enums;

import org.junit.Test;

/**
 * @Auther digege
 * @Date 2021/5/15 @Description：
 *
 * @page com.lichuandi.enums version：1
 */
public class SeasonTest {
  @Test
  public void seasonTest() {
    //ordinal返回枚举变量的序号
    for(SeasonEunm seasion:SeasonEunm.values()) {
      System.out.println(seasion+",ordinal:"+seasion.ordinal()+",name:"+seasion.name());
      System.out.println("枚举变量值:"+seasion.getName()+",枚举变量值:"+seasion.getValue());
    }
  }
}
