package com.lichuandi.string;

import java.util.Arrays;

/**
 * @Auther digege
 * @Date 2021/4/28
 * @Description：com.lichuandi.string version：1
 */
public class StringbuildDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();//value初始化长度16
        StringBuilder stringBuilder2 = new StringBuilder(3);//value指定长度
        StringBuilder s1 = new StringBuilder("abc");//字符串的长度length+16,count 0为3，
        //System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
        s1.append("sfd");//字符串abc之后追加 count 为6
        s1.append("aaaaa").append("bbb").append("ooooooo");//大于19了，扩容新数组
        /*private void ensureCapacityInternal(int minimumCapacity) {
            // overflow-conscious code
            if (minimumCapacity - value.length > 0) {
                value = Arrays.copyOf(value,
                        newCapacity(minimumCapacity));
            }
        }*/
        System.out.println( s1.append("aaaaa")== s1.append("00000"));
    }
}

