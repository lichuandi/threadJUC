package com.lichuandi.annotation.ann;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author lichu java使用@interfac语法来说定义注解 元注解是用来修饰注解的注解，
 * 1、@Target ElementType元素类型是枚举，定义了注解在
 *     类或接口：ElementType.TYPE； 字段：ElementType.FIELD； 方法：ElementType.METHOD；
 *     构造方法：ElementType.CONSTRUCTOR； 方法参数：ElementType.PARAMETER。
 *     实际上注解@Targer中的注解的值定义了是元素类型为注解类型 @Target(ElementType.ANNOTATION_TYPE)
 * 2、元注解 Retention（保留）
 *     定义了注解的生命周期 仅编译期：RetentionPolicy.SOURCE； 仅class文件：RetentionPolicy.CLASS；
 *     运行期：RetentionPolicy.RUNTIME。
 *     如果@Retention不存在，则该Annotation默认为CLASS。因为通常我们自定义的Annotation都是RUNTIME，
 *     所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解：
 * 3、@Repeatable定义注解是否可重复 @Inherited
 *     使用@Inherited定义子类是否可继承父类定义的Annotation。@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效：
 *     4、
 */
@Target(ElementType.TYPE)
//
// @Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnno {
  // 给方法设置默认值的方式
  int type() default 0;

  String level() default "info";
  // 接口中常用value命名
  String value() default "";
}

/** 在使用的时候，如果一个类用到了@MyAnno： 在@MyAnno 注解中已经使用继承的标志 */
@MyAnno(type = 1)
class Person {
  @Range(min=1, max=20)
  public String name;

  @Range(max=10)
  public String city;
  void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
    // 遍历所有Field:
    for (Field field : person.getClass().getFields()) {
      // 获取Field定义的@Range:
      Range range = field.getAnnotation(Range.class);
      // 如果@Range存在:
      if (range != null) {
        // 获取Field的值:
        Object value = field.get(person);
        // 如果值是String:
        if (value instanceof String) {
          String s = (String) value;
          // 判断值是否满足@Range的min/max:
          if (s.length() < range.min() || s.length() > range.max()) {
            throw new IllegalArgumentException("Invalid field: " + field.getName());
          }
        }
      }
    }
  }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
  int min() default 0;
  int max() default 255;
}
class Student extends Person {}
/**
 * 如果定义注解 1 使用@@interface定义注解 2添加参数，默认值 如 String value() default ""; 3用元注解配置注解 如使用@Target，@Retention
 * 一般@Target，@Retention（RUNTIME）的设置的 根据@Retention的配置：
 *
 * <p>SOURCE类型的注解在编译期就被丢掉了； CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM； RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。
 * 如何使用注解完全由工具决定。 SOURCE类型的注解主要由编译器使用，因此我们一般只使用，不编写。 CLASS类型的注解主要由底层工具库使用，涉及到class的加载，一般我们很少用到。
 * 只有RUNTIME类型的注解不但要使用，还经常需要编写。
 * 因为注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，因此，读取注解，需要使用反射API。
 *
 * <p>Java提供的使用反射API读取Annotation的方法包括：
 *
 * <p>判断某个注解是否存在于Class、Field、Method或Constructor：
 *
 * <p>Class.isAnnotationPresent(Class) Field.isAnnotationPresent(Class)
 * Method.isAnnotationPresent(Class) Constructor.isAnnotationPresent(Class) 例如：
 */
