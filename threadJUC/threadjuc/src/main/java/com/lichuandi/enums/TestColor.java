package com.lichuandi.enums;

import org.checkerframework.checker.units.qual.C;

/**
 * @Auther digege
 * @Date 2021/5/14
 * @Description：com.lichuandi.enums version：
 */
public class TestColor {
    public static void main(String[] args) {
        ColorEnum[] values = ColorEnum.values();//把枚举变成数组
        System.out.println(values.length);
        ColorEnum red = ColorEnum.valueOf("RED");
        System.out.println(red);
        System.out.println(ColorEnum.valueOf("RED"));
        for (int i = 0; i < ColorEnum.values().length; i++) {
            System.out.println("颜色成员："+ColorEnum.values()[i]);
        }
        compare(ColorEnum.valueOf("RED"));

    }
    public static  void compare(ColorEnum colorEnum){
        for (int i = 0; i < ColorEnum.values().length; i++) {
            System.out.println(colorEnum+"与"+ColorEnum.values()[i]+colorEnum.compareTo(ColorEnum.values()[i]));
        }
    }

}
