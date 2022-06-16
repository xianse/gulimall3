package com.xunqi.common.timeconsum;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeRecord {

    String methodDesc() default "";
}