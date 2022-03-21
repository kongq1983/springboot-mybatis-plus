package com.kq.swagger.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author kq
 * @date 2022-03-10 17:48
 * @since 2020-0630
 */
public class ApplicationCategorySearchDTO {

    @ApiModelProperty(value = "分类名称",required = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApplicationCategorySearchDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
