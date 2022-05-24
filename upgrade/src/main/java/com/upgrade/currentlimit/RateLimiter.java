package com.upgrade.currentlimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zhangjiaw
 * @Date 2022/5/24 21:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {

    String key() default "rete_limit";

    int time() default 60;

    int count() default 100;

    LimitType limitType() default LimitType.DEFAULT;
}
