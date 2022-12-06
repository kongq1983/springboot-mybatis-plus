package com.kq.swagger.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * @author kq
 * @date 2022-09-09 16:52
 * @since 2020-0630
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Repeatable(EnumValue.List.class)
@Documented
@Constraint(validatedBy = {com.kq.swagger.validate.EnumValueValidator.class})
public @interface EnumValue {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 用来验证String类型参数
    String[] stringValue() default {};

    // 用来验证Int类型参数
    int[] intValue() default {};

    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        EnumValue[] value();
    }
}
