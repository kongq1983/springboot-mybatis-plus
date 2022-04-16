package com.kq.validate.advice;

/**
 * @Author: DingJl
 * @Date: 2022/3/11 14:23
 * @Version 1.0
 */

import com.kq.validate.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author qiudq
 * @Date 2020/04/23
 * @Description controller统一异常捕获
 **/
@RestControllerAdvice
@Slf4j
public class BaseControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResponse handleBusinessException(RuntimeException e, HttpServletRequest request) {
        log.warn("业务异常抛出 {}", e.getMessage());
        return BaseResponse.fail(e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleBusinessException(Exception e, HttpServletRequest request) {
        log.warn("业务异常抛出 {}", e.getMessage());
        return BaseResponse.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public BaseResponse classParameterAnomaly(BindException e, HttpServletRequest request) {
        log.warn("参数异常抛出 {}", e.getBindingResult().getFieldError().getDefaultMessage());
        return BaseResponse.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResponse classParameterAnomaly(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.warn("参数异常抛出 {}", e.getBindingResult().getFieldError().getDefaultMessage());
        return BaseResponse.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }

//    @ExceptionHandler(value = UnauthorizedException.class)
//    public void classParameterAnomaly(UnauthorizedException e, HttpServletRequest request, HttpServletResponse response) {
//        log.warn("参数异常抛出 {}",e.getMessage());
//       response.setStatus(401);
//       return;
//    }


}
