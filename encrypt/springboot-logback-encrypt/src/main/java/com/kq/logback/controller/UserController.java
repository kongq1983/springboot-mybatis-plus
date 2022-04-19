package com.kq.logback.controller;

import com.kq.logback.dto.User;
import com.kq.logback.util.ObjectUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * @date 2022-04-19 11:02
 * @since 2020-0630
 */

@Slf4j
@RestController
@Api(tags = {"用户控制器"})
@RequestMapping("/user")
public class UserController {


    @GetMapping()
    public User view(@RequestParam("id") Long id) {

        log.info("租户参数设置-钉钉设置-设置，接收参数:{}", id);
        log.info("email {}","test@163.com"); // 这个不脱敏 要 email :{}  email = {}
        log.info("email:{}","test163@yahoo.com");
        log.info("email={}","testaaa@163.com");
        log.info("email= {}","test@163.com");
        log.info("email ={}","test@163.com");
        log.info("email = {}","test@163.com");
        log.debug("email = {}","test@163.com");
        log.debug("email :{}","test@163.com");
        log.debug("password :{}","12345678");

        User user = ObjectUtil.getUser(id);

        log.info("user : {}",user);

        Map<String,String> map = new HashMap<>();
        map.put("email","test@163.com");
        map.put("password","123456");
        map.put("cardNo","1234567890123456");

        log.info("map : {}",map);

        return user;

    }


}
