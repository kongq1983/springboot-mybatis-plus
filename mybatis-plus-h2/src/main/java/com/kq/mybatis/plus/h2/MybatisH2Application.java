package com.kq.mybatis.plus.h2;

import com.kq.mybatis.plus.h2.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2022-02-15 14:23
 * @since 2020-0630
 */
//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@SpringBootApplication
@MapperScan("com.kq.mybatis.plus.h2.mapper")
public class MybatisH2Application {

//    @Autowired
//    private UserMapper userMapper;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext)SpringApplication.run(MybatisH2Application.class, args);

        UserMapper userMapper = context.getBean(UserMapper.class);
        System.out.println("userMapper="+userMapper);

    }

}
