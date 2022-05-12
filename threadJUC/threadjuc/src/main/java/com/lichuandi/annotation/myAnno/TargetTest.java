package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.*;

@DocumentedTest
@RetentionTest(RetentionPolicyTest.RUNTIME)
@TargetTest(ElementTypeTest.ANNOTATION_TYPE)
public @interface TargetTest {
    ElementTypeTest[] value();
}
