package com.kq.validate.dto;

import com.kq.validate.validate.EnumValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author kq
 * @date 2022-04-14 15:01
 * @since 2020-0630
 */

@Data
public class ChangeStatusDto {


    @NotNull(message = "ID不能为空!")
    @ApiModelProperty(value = "ID",required = true)
    protected Long id;


    @NotNull(message = "状态不能为空!")
    @EnumValue(intValues = {0, 1}, message = "账户状态只能是0或者1")
    @ApiModelProperty(value = "状态 (1: 启用 0:停用)",required = true)
    /*** 1: 启用   0:停用  */
    protected Integer status;


    @NotBlank(message = "爱好不能为空!")
    @EnumValue(strValues = {"football", "vollball"}, message = "只能是football或者vollball")
    private String hobby;


}
