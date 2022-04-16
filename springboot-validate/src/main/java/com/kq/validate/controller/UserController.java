package com.kq.validate.controller;

import com.kq.validate.dto.ChangeStatusDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kq
 * @date 2022-04-16 10:45
 * @since 2020-0630
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{


    @PostMapping("/status")
    @ApiOperation(value = "应用启用-停用", notes = "应用启用-停用")
//    public String changeStatus(@Validated @RequestBody ChangeStatusDto dto) {
    public String changeStatus(@Validated ChangeStatusDto dto) {

        log.info(" 接收参数 : {}",dto);
//        Assert.isFalse(dto.getIsUsing().intValue()!=0 && dto.getIsUsing().intValue()!=1, "无效应用状态");
        // 启用 停用
        return "ok";
    }


}
