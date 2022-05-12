package com.lichuandi.annotation.myAnno;

import com.lichuandi.annotation.RetentionPolicyTest;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@RetentionTest(RetentionPolicyTest.SOURCE)
public @interface SuppressWarningsTest {
    String[] value();
}
// SuppressWarnings 的作用是，让编译器对"它所标注的内容"的某些警告保持静默。例如，"@SuppressWarnings(value={"deprecation", "unchecked"})" 表示对"它所标注的内容"中的 "SuppressWarnings 不再建议使用警告"和"未检查的转换时的警告"保持沉默。

