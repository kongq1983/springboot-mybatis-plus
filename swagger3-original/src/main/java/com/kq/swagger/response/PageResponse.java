package com.kq.swagger.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kq
 * @date 2022-03-14 15:01
 * @since
 */
@Data
@ApiModel
public class PageResponse<T> extends BaseResponse{

    @ApiModelProperty(value = "总条数",position = 5)
    private long total;
    @ApiModelProperty(value = "每页显示条数",position = 6)
    private long size;
    @ApiModelProperty(value = "当前页",position = 7)
    private long current;


}
