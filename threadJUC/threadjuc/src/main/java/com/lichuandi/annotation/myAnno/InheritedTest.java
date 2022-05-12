package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

@DocumentedTest
@RetentionTest(RetentionPolicyTest.RUNTIME)
@TargetTest(ElementTypeTest.ANNOTATION_TYPE)
public @interface InheritedTest {
}
//它的用来修饰 Inherited，意味着 Inherited 实现了 java.lang.annotation.Annotation 接口；即 Inherited 就是一个注解。
//@Inherited 的含义是，它所标注的Annotation将具有继承性。
