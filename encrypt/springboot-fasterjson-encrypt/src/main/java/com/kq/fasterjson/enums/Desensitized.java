package com.kq.fasterjson.enums;

import java.lang.annotation.*;

/**
 * @author kq
 * @date 2022-04-08 10:49
 * @since 2020-0630
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {

    //脱敏类型(规则)
    SensitiveTypeEnum type();

}
