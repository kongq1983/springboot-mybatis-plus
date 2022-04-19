package com.kq.mybatisplus.annotations;

import com.kq.mybatisplus.enums.DesensitionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据脱敏
 * @author kq
 * @date 2022-04-19 18:59
 * @since
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {
    /**
     * 脱敏规则类型
     * @return
     */
    DesensitionType type();

    /**
     * 附加值, 自定义正则表达式等
     * @return
     */
    String[] attach() default "";
}
