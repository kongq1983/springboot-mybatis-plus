package com.kq.logback.dto;

import lombok.Data;

/**
 * @author kq
 * @date 2022-04-19 10:57
 * @since 2020-0630
 */
@Data
public class User {

    private Long id;

    private String username;

    private String cardNo;

    private String mobile;

    private String password;

}
