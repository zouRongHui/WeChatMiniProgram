package com.rone.annotation;

import com.rone.enumeration.UserInfoTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户类型权限注解，用于判断当前用户是有请求该接口的权限
 *
 * @author rone
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserTypeValidation {

    UserInfoTypeEnum[] supportUserType() default {};
}
