package com.kq.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 *
 * 访问  http://localhost:10000/doc.html
 * @author kq
 * @date 2022-03-14 18:28
 * @since 2020-0630
 */


@SpringBootApplication
public class SwaggerOriginApplication {

    public static void main(String[] args) {

        SpringApplication.run(SwaggerOriginApplication.class, args);

    }

}
