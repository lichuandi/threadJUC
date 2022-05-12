package com.lichuandi.annotation.ann;

import lombok.val;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author digege
 * @date 2021/9/3 16:38
 * @description：使用注解
 * 通过反射使用 判断某个注解是否存在于Class、Field、Method或Constructor：
 *     <p>Class.isAnnotationPresent(Class) Field.isAnnotationPresent(Class)
 *     Method.isAnnotationPresent(Class) Constructor.isAnnotationPresent(Class)
 *     使用反射API读取Annotation：
 *     <p>Class.getAnnotation(Class) Field.getAnnotation(Class) Method.getAnnotation(Class)
 *     Constructor.getAnnotation(Class)
 *
 * @page com.lichuandi.annotation.ann version：1
 */
public class MyAnnoTest {
  public static void main(String[] args) {

    //使用注解 获取注解，
    MyAnno annotation = Person.class.getAnnotation(MyAnno.class);
   //调用注解里面的方法,PerSon是注解是继承了MyAnno因为使用了@Inherited
    int type = annotation.type();
    System.out.println(type);
    String level = annotation.level();
    System.out.println(level);
    //判断注解是否存在
    Class personClass = Person.class;

    if (personClass.isAnnotationPresent(MyAnno.class)){
      MyAnno classAnnotation = (MyAnno)personClass.getAnnotation(MyAnno.class);
      int type1 = classAnnotation.type();
      String level1 = classAnnotation.level();
    }
    MyAnno myAnno = (MyAnno)personClass.getAnnotation(MyAnno.class);

    if (myAnno!=null){

    }
    //读取注解，先用反射获取Method实例然后读取方法参数的所有注解
    //读取方法、字段和构造方法的Annotation和Class类似。但要读取方法参数的Annotation就比较麻烦一点，因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。
    Class<Person> aClass = Person.class;
    // 获取Method实例:
   // Method m =aClass.getMethod("")
// 获取所有参数的Annotation:
 //   Annotation[][] annos = m.getParameterAnnotations();
// 第一个参数（索引为0）的所有Annotation:
  //  Annotation[] annosOfName = annos[0];
    //for (Annotation anno : annosOfName) {
    //  if (anno instanceof Range) { // @Range注解
     //   Range r = (Range) anno;
   //   }
     // if (anno instanceof NotNull) { // @NotNull注解
     //   NotNull n = (NotNull) anno;
    //  }
   // }
  }
}
