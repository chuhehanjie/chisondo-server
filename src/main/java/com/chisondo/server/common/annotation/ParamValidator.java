package com.chisondo.server.common.annotation;

import com.chisondo.server.common.validator.BusiValidator;

import java.lang.annotation.*;
import java.util.List;
import java.util.Map;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamValidator {
    Class<? extends BusiValidator> [] value();

    /**
     * 链式调用
     * 如设置为 false ，则建议校验方法独立调用
     * @return
     */
//    boolean chainCall() default true;

    /**
     * 是否查询类校验
     * @return
     */
    boolean isQuery() default false;
}
