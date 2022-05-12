package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.ElementTypeTest;
import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

//定义一个不可以的方法 所标注内容，不再被建议使用。
@DocumentedTest
@RetentionTest(RetentionPolicyTest.RUNTIME)
//@TargetTest(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
@TargetTest(value ={ElementTypeTest.CONSTRUCTOR,ElementTypeTest.FIELD,ElementTypeTest.LOCAL_VARIABLE,ElementTypeTest.METHOD,ElementTypeTest.PACKAGE,
        ElementTypeTest.PARAMETER,ElementTypeTest.TYPE
})
public @interface DeprecatedTest {
}
