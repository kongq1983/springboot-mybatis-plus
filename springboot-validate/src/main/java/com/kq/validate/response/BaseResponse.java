package com.kq.validate.response;

import com.kq.validate.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: DingJl
 * @Date: 2022/3/9 16:51
 * @Version 1.0
 */
@Data
@ApiModel
public class BaseResponse<T> {

    private static final long serialVersionUID = 7498483649536881777L;
    @ApiModelProperty(value = "标识代码,200表示成功，非200表示出错",position=1)
    protected Integer code;

    @ApiModelProperty(value = "提示信息,供报错时使用",position = 2)
    protected String msg;

    @ApiModelProperty(value = "返回的数据",position = 3)
    protected T data;

    @ApiModelProperty(value = "提示信息,供报错时使用",position = 4)
    protected String sysCode;
    public BaseResponse() {
    }

    public BaseResponse(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }
    public  BaseResponse(Integer status, String msg,String sysCode, T data) {
        this.code = status;
        this.sysCode=sysCode;
        this.msg = msg;
        this.data = data;
    }
    public static BaseResponse success(Integer code, String msg) {
        return new BaseResponse(code, msg, null);
    }

    public static <T> BaseResponse<T> fail() {
        return  result(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg(),null,null);
    }

    public static BaseResponse fail( String msg) {
        return  result(ResultCode.FAIL.getCode(),msg,null,null);
    }
    public static BaseResponse fail(Integer code, String msg) {

        return  result(code,msg,null,null);
    }

    public static <T> BaseResponse<T> success() {
        return  result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null,null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return  result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null,data);
    }

    private static <T> BaseResponse<T> result(Integer code, String msg, String sysCode, T data) {
        return new BaseResponse<T>(code, msg, sysCode, data);
    }

}