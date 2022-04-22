package com.kq.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author kq
 * @date 2022-04-22 14:37
 * @since 2020-0630
 */
@Data
public class User {

    //id属性是给mongodb用的，用@Id注解修饰
//    @Id
    private String id;
    private String username;
    private String name;
    private String[] hobbys;
    private int age;

}
