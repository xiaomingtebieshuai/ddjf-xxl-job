package com.ddjf.ddjfxxljob.handler.annotation;

import com.xxl.job.core.handler.annotation.JobHandler;

import java.lang.annotation.*;

/**
 * annotation for job handler
 * @author 2016-5-17 21:06:49
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JobHandler
@Inherited
public @interface DdjfJobHandler {

    String value() default "";

}
