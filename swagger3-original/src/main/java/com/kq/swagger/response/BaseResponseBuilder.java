package com.kq.swagger.response;


import com.kq.swagger.util.ResultCode;

/**
 * @Author: DingJl
 * @Date: 2022/3/14 9:18
 * @Version 1.0
 */
public class BaseResponseBuilder {


    public static <T> BaseResponse<T> fail() {
        return result(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMsg(),null,null);
    }

    public static <T> BaseResponse<T> fail(String msg) {
        return result(ResultCode.FAIL.getCode(), msg,null,null);
    }

    public static <T> BaseResponse<T> fail(Integer code, String msg) {
        return result(code, msg,null,null);
    }

    public static <T> BaseResponse<T> success() {
        return result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),null,null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),null,data);
    }

    private static <T> BaseResponse<T> result(Integer code, String msg, String sysCode, T data) {
        return new BaseResponse<T>(code, msg, sysCode, data);
    }

}
