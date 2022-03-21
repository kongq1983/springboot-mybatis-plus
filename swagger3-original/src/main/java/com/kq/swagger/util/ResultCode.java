package com.kq.swagger.util;

/**
 * @author kq
 * @Description 返回的code值
 **/
public enum ResultCode {

    /**
     * -1为特别错误码，需要系统指定错误信息，不建议使用失败两个字
     */
    FAIL(-1, "请求失败", "Failed"),
    SUCCESS(200, "请求成功", "Success");




    private Integer code;
    private String msg;
    private String enName;

    private ResultCode(Integer code, String msg, String enName) {
        this.code = code;
        this.msg = msg;
        this.enName = enName;
    }

    public Integer getCode() {
        return code;
    }

    public String getEnName() {
        return enName;
    }

    public String getMsg() {
        return msg;
    }

}
