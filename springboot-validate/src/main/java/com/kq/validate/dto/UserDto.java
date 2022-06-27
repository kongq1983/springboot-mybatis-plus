package com.kq.validate.dto;

import com.kq.validate.validate.EnumValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author kq
 * @date 2022-06-27 16:34
 * @since 2020-0630
 */

@Data
public class UserDto {

//    @NotNull(message = "ID不能为空!")
    @ApiModelProperty(value = "ID",required = true)
    protected Long id;


    @NotNull(message = "状态不能为空!")
    @EnumValue(intValues = {0, 1}, message = "账户状态只能是0或者1")
    @ApiModelProperty(value = "状态 (1: 启用 0:停用)",required = true)
    /*** 1: 启用   0:停用  */
    protected Integer status;


    private String hobby;

    @ApiModelProperty(value = "账号",required = true)
    private String username;

    @ApiModelProperty(value = "名称",required = true)
    private String name;


}
