package com.kq.swagger.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author kq
 * @date 2022-07-05 15:39
 * @since 2020-0630
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface CheckSign {

}
