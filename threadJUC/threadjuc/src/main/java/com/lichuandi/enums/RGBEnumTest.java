package com.lichuandi.enums;

import org.junit.Test;

/**
 * @Auther digege
 * @Date 2021/5/15
 * @Description：
 * @page com.lichuandi.enums
 * version：1
 */
public class RGBEnumTest {
    @Test
    public void rgbEnumTest(){
        for (RGBEnum rgbEnum:RGBEnum.values()){
      System.out.println(rgbEnum.toString());
        }
    }
}
