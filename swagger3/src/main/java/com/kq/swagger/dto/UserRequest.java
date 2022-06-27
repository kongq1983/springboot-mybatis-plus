package com.kq.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author kq
 * @date 2022-06-27 16:34
 * @since 2020-0630
 */

@Data
public class UserRequest {

//    @NotNull(message = "ID不能为空!")
    @ApiModelProperty(value = "ID",required = true)
    protected Long id;


    @NotNull(message = "状态不能为空!")
    @ApiModelProperty(value = "状态 (1: 启用 0:停用)",required = true)
    /*** 1: 启用   0:停用  */
    protected Integer status;


    private String hobby;

    @ApiModelProperty(value = "账号",required = true)
    private String username;

    @ApiModelProperty(value = "名称",required = true)
    private String name;


}
