package com.lichuandi.enums;

/**
 * @Auther digege
 * @Date 2021/4/28
 * @Description：com.lichuandi.enums version：1
 */
public class TestSeason {
    public static void main(String[] args) {
        Season autumn=Season.AUTUMN;
        System.out.println(autumn);
        Season[] values = Season.values();
        for (Season s:values
             ) {
            System.out.println(s);

        }
        Season autumn1 = Season.valueOf("AUTUMN");
        System.out.println(autumn1);
        Season summer=Season.SUMMER;
        summer.show();

    }
}
