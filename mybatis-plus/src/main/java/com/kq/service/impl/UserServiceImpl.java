package com.kq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.dto.User;
import com.kq.entity.Application;
import com.kq.mapper.ApplicationMapper;
import com.kq.mapper.UserMapper;
import com.kq.service.IApplicationService;
import com.kq.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 平台应用表 服务实现类
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(User user) {
        this.save(user);
    }
}
