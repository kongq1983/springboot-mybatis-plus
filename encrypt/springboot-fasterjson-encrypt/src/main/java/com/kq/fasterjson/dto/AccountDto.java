package com.kq.fasterjson.dto;

import com.kq.fasterjson.enums.Desensitized;
import com.kq.fasterjson.enums.SensitiveTypeEnum;
import lombok.Data;

/**
 * @author kq
 * @date 2022-04-08 10:31
 * @since 2020-0630
 */

@Data
public class AccountDto {

    private Long id;

    @Desensitized(type = SensitiveTypeEnum.CHINESE_NAME)
    private String name;

    @Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String mobile;

    private String username;

    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private String password;

    @Desensitized(type = SensitiveTypeEnum.EMAIL)
    private String email;

}
