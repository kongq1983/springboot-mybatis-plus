package com.kq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-11-17 15:22
 * @since
 */
@SpringBootApplication
@MapperScan("com.kq.mapper")//扫描mapper文件夹
public class MybatisPlusMoreDsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusMoreDsApplication.class, args);
    }

}
