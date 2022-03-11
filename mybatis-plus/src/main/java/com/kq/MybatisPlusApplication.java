package com.kq;

import com.kq.dto.User;
import com.kq.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author kq
 * @date 2022-02-15 15:47
 * @since 2020-0630
 */

@SpringBootApplication
@MapperScan("com.kq.mapper")//扫描mapper文件夹
public class MybatisPlusApplication {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusApplication.class, args);

//        UserMapper userMapper = context.getBean(UserMapper.class);
//        System.out.println("userMapper="+userMapper);
//
//        List<User> userList = userMapper.selectList(null);
//        System.out.println("userList="+userList);

    }

}
