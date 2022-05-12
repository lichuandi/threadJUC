package com.lichuandi.annotation.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author lichu
 */
@Target(ElementType.TYPE)
public @interface Reports {
    Report[] value();
}
