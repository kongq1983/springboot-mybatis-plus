package com.kq.logback.util;

import com.kq.logback.dto.User;

/**
 * @author kq
 * @date 2022-04-19 11:07
 * @since 2020-0630
 */
public class ObjectUtil {

    public static User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("admin");
        user.setCardNo("111012345678901234");
        user.setMobile("16812345678");
        user.setPassword("123456");

        return user;
    }

}
