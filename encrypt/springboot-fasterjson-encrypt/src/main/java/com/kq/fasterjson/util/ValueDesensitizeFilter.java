package com.kq.fasterjson.util;

/**
 * @author kq
 * @date 2022-04-08 11:06
 * @since 2020-0630
 */

import com.alibaba.fastjson.serializer.ValueFilter;
import com.kq.fasterjson.enums.Desensitized;
import com.kq.fasterjson.enums.SensitiveTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**

 在fastjson中使用此过滤器进行脱敏操作
 */
@Slf4j
public class ValueDesensitizeFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitized desensitization;
            if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitized.class)) == null) {
                return value;
            }
            String valueStr = (String) value;
            SensitiveTypeEnum type = desensitization.type();
            switch (type) {
                case CHINESE_NAME:
                    return DesensitizedUtils.chineseName(valueStr);
                case ID_CARD:
                    return DesensitizedUtils.idCardNum(valueStr);
                case FIXED_PHONE:
                    return DesensitizedUtils.fixedPhone(valueStr);
                case MOBILE_PHONE:
                    return DesensitizedUtils.mobilePhone(valueStr);
                case ADDRESS:
                    return DesensitizedUtils.address(valueStr, 8);
                case EMAIL:
                    return DesensitizedUtils.email(valueStr);
                case BANK_CARD:
                    return DesensitizedUtils.bankCard(valueStr);
                case PASSWORD:
                    return DesensitizedUtils.password(valueStr);
                case CARNUMBER:
                    return DesensitizedUtils.carNumber(valueStr);
                default:
            }
        } catch (NoSuchFieldException e) {
            log.error("当前数据类型为{},值为{}", object.getClass(), value);
            return value;
        }
        return value;
    }
}
