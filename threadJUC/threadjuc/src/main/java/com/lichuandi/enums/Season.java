package com.lichuandi.enums;

/**
 * @Auther digege
 * @Date 2021/4/28
 * @Description：com.lichuandi.enums version：1
 */
public enum  Season implements TestSeasons{
    SPRING{
        @Override
        public void show() {
            System.out.println("这时春天...");
        }
    },
    SUMMER {
        @Override
        public void show() {
            System.out.println("这时夏天...");
        }
    },
    AUTUMN {
        @Override
        public void show() {
            System.out.println("这时秋天...");
        }
    },
    WINTER {
        @Override
        public void show() {
            System.out.println("这时冬天...");
        }
    };

    Season() {
    }

   /* @Override
    public void show() {

    }*/
}
