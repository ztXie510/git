package me.spring.annotation;

import java.lang.annotation.*;

/**
 * Custom annotation — mark methods to auto-log via AOP to sys_log table.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /** Operation description, e.g., "添加收支记录" */
    String value() default "";
}
