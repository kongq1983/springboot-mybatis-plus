package com.kq.swagger.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DingJl
 * @Date: 2022/3/9 14:16
 * @Version 1.0
 */
@Configuration
@EnableOpenApi
//@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        List<Response> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseBuilder().code("200").description("SUCCESS").build());
        responseMessageList.add(new ResponseBuilder().code("400").description("Bad Request").build());

        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kq"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(globalRequestParameters())
                .apiInfo(apiInfo())
                .globalResponses(HttpMethod.GET,responseMessageList);
    }

    private List<RequestParameter> globalRequestParameters() {
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder().in(ParameterType.HEADER).name("mytoken").required(false).query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
        return Collections.singletonList(parameterBuilder.build());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("King管理API")
                .description("King管理API")
                .version("1.0")
                .contact(new Contact("king","www.king.com",""))
                .build();
    }
}
