package com.lichuandi.annotation.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author lichu
 */
@Repeatable(Reports.class)
@Target(value = ElementType.TYPE)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
 /**
  * @author lichu
  * 经过@Repeatable修饰后，在某个类型声明处，就可以添加多个@Report注解：
  */
 @Report(type = 1,level = "debug")
 @Report(type = 2,level = "warning")
 @interface ReportTest {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
