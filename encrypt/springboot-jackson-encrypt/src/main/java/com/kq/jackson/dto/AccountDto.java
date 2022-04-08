package com.kq.jackson.dto;

import com.kq.jackson.annotation.EmailDesensitize;
import com.kq.jackson.annotation.IDCardDesensitize;
import com.kq.jackson.annotation.PhoneDesensitize;
import com.kq.jackson.annotation.StringDesensitize;
import lombok.Data;

/**
 * @author kq
 * @date 2022-04-08 10:31
 * @since 2020-0630
 */

@Data
public class AccountDto {

    private Long id;

    private String name;

    @PhoneDesensitize
    private String mobile;

    private String username;

    @StringDesensitize
    private String password;

    @EmailDesensitize
    private String email;

    @IDCardDesensitize
    private String cardNo;

}
