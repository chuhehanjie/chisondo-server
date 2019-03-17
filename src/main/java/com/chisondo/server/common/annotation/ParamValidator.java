package com.chisondo.server.common.annotation;

import com.chisondo.server.common.validator.BusiValidator;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamValidator {
//    BusiValidator validators();
}
