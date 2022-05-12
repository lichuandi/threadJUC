package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Auther digege
 * @Date 2021/6/6
 * @Description：
 * @page com.lichuandi.annotation.myAnno
 * version：
 */
@DocumentedTest
@TargetTest(ElementTypeTest.TYPE)
@RetentionTest(RetentionPolicyTest.RUNTIME)
public  @interface MyAnnotationTest {

}

/**
 * @interface 使用 @interface 定义注解时，意味着它实现了 java.lang.annotation.Annotation 接口，即该注解就是一个Annotation。
 *     <p>定义 Annotation 时，@interface 是必须的。 注意：它和我们通常的 implemented 实现接口的方法不同。Annotation
 *     接口的实现细节都由编译器完成。通过 @interface 定义注解后，该注解不能继承其他的注解或接口。
 */
// MyAnnotation1 是来修饰"类、接口（包括注释类型）或枚举声明"的注解。
// 没有@TargetTest修饰所有
// java 常用的 Annotation：
//
// @Deprecated  -- @Deprecated 所标注内容，不再被建议使用。
// @Override    -- @Override 只能标注方法，表示该方法覆盖父类中的方法。
// @Documented  -- @Documented 所标注内容，可以出现在javadoc中。
// @Inherited   -- @Inherited只能被用来标注“Annotation类型”，它所标注的Annotation具有继承性。
// @Retention   -- @Retention只能被用来标注“Annotation类型”，而且它被用来指定Annotation的RetentionPolicy属性。
// @Target      -- @Target只能被用来标注“Annotation类型”，而且它被用来指定Annotation的ElementType属性。
// @SuppressWarnings -- @SuppressWarnings 所标注内容产生的警告，编译器会对这些警告保持静默。

