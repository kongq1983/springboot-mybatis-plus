package com.kq.validate.controller;

import com.kq.validate.enums.ResultCode;
import com.kq.validate.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kq
 * @date 2022-04-16 10:53
 * @since 2020-0630
 */
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex)  {
        BindingResult bindingResult = ex.getBindingResult();

        BaseResponse<Object> result = new BaseResponse<>();
        result.setCode(ResultCode.FAIL.getCode());


        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            result.setMsg(fieldError.getDefaultMessage());
            break;
        }

        logger.debug("check fail msg : {}",result.getMsg());

        return result;
    }

}
