package com.kq.swagger.conf;

import com.kq.swagger.interceptor.SignInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author kq
 * @date 2022-03-14 19:10
 * @since 2020-0630
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    private SignInterceptor signInterceptor;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        registry.addInterceptor(signInterceptor);
    }

}
