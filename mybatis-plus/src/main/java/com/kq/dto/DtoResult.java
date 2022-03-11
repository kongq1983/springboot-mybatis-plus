package com.kq.dto;


/**
 * 数据传输对象
 *
 * @author qianyangyang
 * @since 3.0.0.0
 */
public class DtoResult {

    private String code = "16800000";

    private Object result;

    public DtoResult() {
    }

    public DtoResult(String code) {
        this.code = code;
    }

    public DtoResult(String code, String re) {
        this.code = code;
        this.result = re;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
