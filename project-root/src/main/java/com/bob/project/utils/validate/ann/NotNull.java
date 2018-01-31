package com.bob.project.utils.validate.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

import static com.bob.project.utils.validate.Validator.NOT_NULL;

/**
 * 非空
 *
 * @author wb-jjb318191
 * @create 2018-01-31 10:12
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Payload(NOT_NULL)
public @interface NotNull {

}