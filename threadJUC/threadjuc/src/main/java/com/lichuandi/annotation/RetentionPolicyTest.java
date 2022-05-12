package com.lichuandi.annotation;

/**
 * @author lichu
 * @Auther digege
 * @Date 2021/6/6
 * @Description：
 * @page com.lichuandi.annotation
 * version：
 */
public enum RetentionPolicyTest {
    /* Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了  */
    SOURCE,
    /* 编译器将Annotation存储于类对应的.class文件中。默认行为  */
    CLASS,
    /* 编译器将Annotation存储于class文件中，并且可由JVM读入 */
    RUNTIME
}
