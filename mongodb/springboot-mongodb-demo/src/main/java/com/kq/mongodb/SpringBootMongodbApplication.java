package com.kq.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-04-22 14:43
 * @since 2020-0630
 */
@SpringBootApplication
public class SpringBootMongodbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

}
