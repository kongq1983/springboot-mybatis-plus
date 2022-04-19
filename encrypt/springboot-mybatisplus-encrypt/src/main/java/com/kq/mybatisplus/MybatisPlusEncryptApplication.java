package com.kq.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-02-15 15:47
 * @since 2020-0630
 */

@SpringBootApplication
@MapperScan("com.kq.mybatisplus.mapper")//扫描mapper文件夹
public class MybatisPlusEncryptApplication {

    public static void main(String[] args) throws Exception{

        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusEncryptApplication.class, args);

    }

}
