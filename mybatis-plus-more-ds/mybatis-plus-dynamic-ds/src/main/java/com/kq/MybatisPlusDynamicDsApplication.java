package com.kq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-11-17 15:22
 * @since 2020-0630
 */

@SpringBootApplication
@MapperScan("com.kq.mapper")//扫描mapper文件夹
public class MybatisPlusDynamicDsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusDynamicDsApplication.class, args);
    }

}
