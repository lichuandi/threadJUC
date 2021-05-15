package com.lichuandi.enums;

import org.junit.Test;

/**
 * @Auther digege
 * @Date 2021/5/15
 * @Description：
 * @page com.lichuandi.enums
 * version：1
 */
public class TypeParaEnumTest {
    @Test
    public void TypeTest(){
        String typeName = "f5";
        TypeParaEnum type = TypeParaEnum.fromTypeName(typeName);
        //type:是TypeEnum类实例化对象     typeName：实例化对象type的值
        // ordinal：实例化对象type的序号（int）          排序值(默认自带的属性 ordinal 的值)
        //name：实化对象的名字（String）                            枚举名称(即默认自带的属性 name 的值)
        System.out.println(type+",typeName:"+type.getTypeName()+",ordinal:"+type.ordinal()+",name:"+type.name());
    }
}
