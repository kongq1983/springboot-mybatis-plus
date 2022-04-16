package com.kq.validate.advice;

import com.kq.validate.response.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: DingJl
 * @Date: 2022/3/14 10:41
 * @Version 1.0
 */
@RestControllerAdvice
public class BaseResponseAdvice implements ResponseBodyAdvice<BaseResponse> {
    @Value("${spring.application.name}")
    private String syscode;
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println(methodParameter.getParameterType().getName());
        if (methodParameter.getParameterType().getName().equals(BaseResponse.class.getName())){
            return  true;
        }
        return false;
    }

    @Override
    public BaseResponse beforeBodyWrite(BaseResponse baseResponse, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        baseResponse.setSysCode(syscode);
        return baseResponse;
    }
}
