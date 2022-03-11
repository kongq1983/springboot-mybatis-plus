package com.kq.mybatis.plus.h2.dto;

import lombok.Data;

/**
 * @author kq
 * @date 2022-02-15 14:44
 * @since 2020-0630
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
