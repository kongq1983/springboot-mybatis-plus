package com.kq.mybatisplus.entity;

import com.kq.mybatisplus.annotations.Desensitization;
import com.kq.mybatisplus.enums.DesensitionType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kq
 * @date 2022-02-15 13:58
 * @since 2020-0630
 */
@Data
public class User implements Serializable {

    private Long id;

    @Desensitization(type = DesensitionType.REAL_NAME)  //脱敏定义
    private String name;

    private Integer age;

    @Desensitization(type = DesensitionType.EMAIL)
    private String email;

}