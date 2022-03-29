package com.kq.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-02-15 15:47
 * @since 2020-0630
 */

@SpringBootApplication(scanBasePackages = "com.kq.app")
@MapperScan("com.kq.app.dao")//扫描mapper文件夹 定位到具体的dao 否则service也会被代理 ，会报错
public class MybatisPlusImportApplication {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusImportApplication.class, args);

//        UserMapper userMapper = context.getBean(UserMapper.class);
//        System.out.println("userMapper="+userMapper);
//
//        List<User> userList = userMapper.selectList(null);
//        System.out.println("userList="+userList);

    }

}
