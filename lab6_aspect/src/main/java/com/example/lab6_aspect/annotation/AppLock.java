package com.example.lab6_aspect.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AppLock {

    String message() default "";

    /**
     * 要校验的参数位置
     * @return
     */
    int argIndex() default 0;

    /**
     * 获取appType方法
     * @return
     */
    String getAppType() default "getAppType";

    /**
     * 获取appCode方法
     * @return
     */
    String getAppCode() default "getAppCode";
}
