package com.kq.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kq.mybatisplus.entity.User;

/**
 * @author kq
 * @date 2022-02-15 15:46
 * @since 2020-0630
 */
//在对应的Mapper上继承基本的类baseMapper
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD已经编写完成
    //不需要像以前的配置一些xml

}