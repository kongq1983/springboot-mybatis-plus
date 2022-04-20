package com.kq.mybatisplus.controller;

import com.kq.mybatisplus.dto.DtoResult;
import com.kq.mybatisplus.entity.User;
import com.kq.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author kq
 * @date 2022-03-09 14:45
 * @since 2020-0630
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping(value = "/user/list")
    public DtoResult sendMessage(
//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {


        List<User> userList = userMapper.selectList(null);
        log.info("userList="+userList);

        DtoResult result = new DtoResult();
        result.setResult(userList);

        return result;
    }


}
