package com.kq.swagger.interceptor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kq.swagger.annotation.CheckSign;
import com.kq.swagger.response.BaseResponse;
import com.kq.swagger.util.SignUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kq
 * @date 2022-07-05 15:37
 * @since 2020-0630
 */
@Component
public class SignInterceptor extends HandlerInterceptorAdapter {

    protected Logger logger = LoggerFactory.getLogger(SignInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        boolean hasNotLogin = handlerMethod.hasMethodAnnotation(CheckSign.class);

        //没有该注解，则校验通过
        if (!hasNotLogin){
            return true;
        }

        String originSign = request.getParameter("sign");

        InputStream inputStream = request.getInputStream();

        ObjectMapper objectMapper = new ObjectMapper();
        // bodyMap
        Map<String, Object> bodyMap = objectMapper.readValue(inputStream,new TypeReference<Map<String,Object>>(){});

        logger.info("get bodyMap : {}",bodyMap);
        //
        Map<String, Object> bothMap = new TreeMap<>(bodyMap);
        mergeMap(request,bothMap);


        String sign = SignUtils.createSign(bothMap);

        if(!StringUtils.equals(originSign,sign)) {
            // 验证不通过
            this.writeFail(response);

            return false;
        }

        return true;
    }

    private void writeFail(HttpServletResponse response) {
        BaseResponse responseEntity = BaseResponse.fail("sign认证失败!");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(response.getOutputStream(),responseEntity);
        }catch (Exception e){
            logger.error("序列化出错!",e);
        }

    }


    private void mergeMap(HttpServletRequest request,Map<String, Object> bothMap) {
        Map<String, String[]> paramMap = request.getParameterMap();

        logger.info("get paramMap : {}",paramMap);

        for(Map.Entry<String,String[]> kv : paramMap.entrySet()) {
            String[] value = kv.getValue();
            if(value!=null) {
                bothMap.put(kv.getKey(), kv.getValue()[0]);
            }else {
                bothMap.put(kv.getKey(), null);
            }

            logger.info("parameter key ={} ,value={}",kv.getKey(),bothMap.get(kv.getKey()));
        }
    }

}
