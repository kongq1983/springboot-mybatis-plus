package com.kq.dto;

import lombok.Data;

/**
 * @author kq
 * @date 2022-02-15 13:58
 * @since 2020-0630
 */
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}