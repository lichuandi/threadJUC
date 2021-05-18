package com.lichuandi.hutool;

import cn.hutool.core.clone.CloneRuntimeException;

/**
 * @Auther digege
 * @Date 2021/5/17
 * @Description：
 * @page com.lichuandi.hutool
 * version：1
 */
public class CatTest {

    public static class Cat {
        private String name = "miaomiao";
        private int age = 2;

        @Override
        public Cat clone() {
            try {
                return (Cat) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new CloneRuntimeException(e);
            }
        }

    }
}
