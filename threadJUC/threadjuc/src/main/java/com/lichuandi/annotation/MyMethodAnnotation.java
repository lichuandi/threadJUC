package com.lichuandi.annotation;

/**
 * @author digege
 * @date 2021/11/10 17:08
 * @description：TODO
 * @page com.lichuandi.annotation
 * version：1
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {

    public String title() default "";

    public String description() default "";

}
