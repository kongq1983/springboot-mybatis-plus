package com.kq.swagger.contrller;


import com.kq.swagger.response.BaseResponse;
import com.kq.swagger.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kq
 * @date 2022-03-11 13:58
 * @since 1.0.0
 */
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex)  {
        BindingResult bindingResult = ex.getBindingResult();

        BaseResponse<Object> result = new BaseResponse<>();
        result.setCode(-1);


        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            result.setMsg(fieldError.getDefaultMessage());
            break;
        }

        logger.debug("check fail msg : {}",result.getMsg());

        return result;
    }


}
