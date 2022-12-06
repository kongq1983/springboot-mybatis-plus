package com.kq.swagger.contrller;

import com.kq.swagger.annotation.CheckSign;
import com.kq.swagger.dto.UserRequest;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author kq
 * @date 2022-04-16 10:45
 * @since 2020-0630
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{


    // I/O error while reading input message; nested exception is java.io.IOException: Stream closed
    @CheckSign
    @PostMapping("/add0")
    @ApiOperation(value = "新增", notes = "新增用户")
    public String addTemn(@Validated @RequestBody UserRequest dto, @RequestBody String json, @RequestBody Map<String,Object> map) {

        log.info(" 接收参数 : dto {}",dto);
        log.info(" 接收参数 : json {}",json);
        log.info(" 接收参数 : map {}",map);
//        Assert.isFalse(dto.getIsUsing().intValue()!=0 && dto.getIsUsing().intValue()!=1, "无效应用状态");
        // 启用 停用
        return "ok";
    }


    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "新增用户")
    public String add(@Validated @RequestBody UserRequest dto) {

        log.info(" 接收参数 : dto {}",dto);
//        Assert.isFalse(dto.getIsUsing().intValue()!=0 && dto.getIsUsing().intValue()!=1, "无效应用状态");
        return "ok";
    }


}
