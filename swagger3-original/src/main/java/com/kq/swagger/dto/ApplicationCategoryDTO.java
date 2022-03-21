package com.kq.swagger.dto;

import com.kq.swagger.validate.AddGroup;
import com.kq.swagger.validate.EditGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


/**
 * @author kq
 * @date 2022-03-10 11:11
 * @since 2020-0630
 */
@Data
@ApiModel
public class ApplicationCategoryDTO {

    @NotBlank(message = "分类ID不能为空！",groups = {EditGroup.class})
    @ApiModelProperty(value = "分类ID(新增接口忽略)",example = "1")
    private String id;

    @NotBlank(message = "分类名称不能为空！",groups = {AddGroup.class, EditGroup.class})
    @Length(max=32,message="分类名称必须在1和32字符之间",groups = {AddGroup.class, EditGroup.class})
    @ApiModelProperty(value = "分类名称",example = "人事管理")
    private String name;

    @NotBlank(message = "分类编码不能为空！",groups = {AddGroup.class, EditGroup.class})
    @Length(max=32,message="分类编码必须在1和32字符之间",groups = {AddGroup.class, EditGroup.class})
    @ApiModelProperty(value = "分类编码",example = "RSGL")
    private String code;

    @Length(max=512,message="分类说明不能大于512字符",groups = {AddGroup.class, EditGroup.class})
    @ApiModelProperty(value = "分类说明",example = "人事管理")
    private String description;

//    @ApiModelProperty(value = "版本号",example = "1")
//    private Integer version;

}
