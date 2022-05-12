package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@DocumentedTest
// 则表示它可以出现在 javadoc 中。
// 定义 Annotation 时，@Documented 可有可无；若没有定义，则 Annotation 不会出现在 javadoc 中。
@RetentionTest(RetentionPolicyTest.RUNTIME)
@TargetTest(ElementTypeTest.ANNOTATION_TYPE)
public @interface DocumentedTest {}
