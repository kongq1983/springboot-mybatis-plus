package com.kq.exception;

/**
 * @author kq
 * @date 2022-11-17 10:43
 * @since 2020-0630
 */
public class BusinessException extends RuntimeException{

    private Integer code;

    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }


}
