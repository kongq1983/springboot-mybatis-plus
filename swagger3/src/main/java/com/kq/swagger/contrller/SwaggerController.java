package com.kq.swagger.contrller;

import com.kq.swagger.dto.ApplicationCategoryDTO;
import com.kq.swagger.dto.UserDTO;
import com.kq.swagger.response.BaseResponse;
import com.kq.swagger.util.ResultCode;
import com.kq.swagger.validate.AddGroup;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author kq
 * @date 2022-03-21 16:31
 * @since 2020-0630
 */
@Slf4j
@RestController
@Api(tags = {"SwaggerDemo"})
@RequestMapping("/app/swagger")
public class SwaggerController {



    @PostMapping()
    @ApiOperation(value="注册",notes="ADD")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username1", value = "用户帐号",required = true,paramType = "body"),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "mobile", value = "手机", required = true)
    })
    public BaseResponse<Object> register(@Validated({AddGroup.class}) @RequestBody UserDTO dto){

        log.debug("新增分类接收参数:{}",dto);


        try {
            dto.setId(null); // 新增接口没有id的值
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }


    @PostMapping("/register1")
    @ApiOperation(value="注册1",notes="ADD")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户帐号",paramType = "body"),
//            @ApiImplicitParam(name = "password", value = "密码",paramType = "body"),
//            @ApiImplicitParam(name = "mobile", value = "手机",paramType = "body")
//    })\




    @ApiImplicitParam(name = "dto", value = "用户帐号",paramType = "body")
    public BaseResponse<Object> register1(@RequestBody Map<String,String> dto){

        log.debug("新增分类接收参数:{}",dto);


        try {
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }


    @PostMapping("/register2")
    @ApiOperation(value="注册2",notes="ADD")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username1", value = "用户帐号",required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "mobile", value = "手机", required = true)
    })
    public BaseResponse<Object> register2(UserDTO dto){

        log.debug("新增分类接收参数:{}",dto);


        try {
            dto.setId(null); // 新增接口没有id的值
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }


    @GetMapping("/user/{id}")
    @ApiOperation("根据ID获取信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户编号",required = true,paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code=500,message="服务器内部报错"),
            @ApiResponse(code=400,message="参数校验失败"),
            @ApiResponse(code=404,message="路径不存在")
    })
    public Object load(@PathVariable("id") Integer id){
        return null;
    }

}
