package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@DocumentedTest
@RetentionTest(RetentionPolicyTest.RUNTIME)
@TargetTest(ElementTypeTest.ANNOTATION_TYPE)
public @interface RetentionTest {
    RetentionPolicyTest value();
}
