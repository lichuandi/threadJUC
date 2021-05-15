package com.lichuandi.enums;

import org.junit.Test;

/**
 * @Auther digege
 * @Date 2021/5/14
 * @Description：com.lichuandi.enums version：1
 */
public class ColorTset {

//ordinal返回枚举变量的序号
@Test
    public void setColor() {
        for(ColorEnum color:ColorEnum.values()) {
            System.out.println(color+",ordinal:"+color.ordinal()+",name:"+color.name());
        }

    }


}
