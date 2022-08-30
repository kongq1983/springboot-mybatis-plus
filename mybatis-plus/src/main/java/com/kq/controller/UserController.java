package com.kq.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kq.dto.DtoResult;
import com.kq.dto.User;
import com.kq.mapper.UserMapper;
import com.kq.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping(value = "/get/user")
    public DtoResult sendMessage(
//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {


        List<User> userList = userMapper.selectList(null);
        System.out.println("userList="+userList);

        DtoResult result = new DtoResult();
        result.setResult(userList);

        return result;
    }


    @GetMapping(value = "/user/birthday")
    public DtoResult getUserListByBirthday(
//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getBirthday, DateUtil.stringToDateTime("2000-01-01 12:30:12"));
        queryWrapper.eq(User::getBirthday, DateUtil.stringToDateTime("2000-01-01 00:00:01"));

        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("userList="+userList);

        LambdaQueryWrapper<User> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(User::getBirthday, DateUtil.stringToDate("2000-01-01"));

        List<User> userList1 = userMapper.selectList(queryWrapper1);
        log.info("userList1="+userList1);

        DtoResult result = new DtoResult();


        Map<String,Object> map = new HashMap<>();
        map.put("userList",userList);
        map.put("userList1",userList1);

        result.setResult(map);

        return result;
    }


    @GetMapping(value = "/user/c/birthday")
    public DtoResult getUserListByChineseBirthday(
//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getBirthday, DateUtil.stringToDateTime("2000-01-01 12:30:12"));
        queryWrapper.eq(User::getBirthday, LocalDate.parse("2000-01-01"));

        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("userList="+userList);

        DtoResult result = new DtoResult();

        Map<String,Object> map = new HashMap<>();
        map.put("userList",userList);

        result.setResult(map);

        return result;
    }


    @GetMapping(value = "/user/save")
    public DtoResult saveUser(
//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {

        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date());
        user.setChineseBirthday(LocalDate.now());
        user.setName("test");

        userMapper.insert(user);

        DtoResult result = new DtoResult();

        return result;
    }


}
