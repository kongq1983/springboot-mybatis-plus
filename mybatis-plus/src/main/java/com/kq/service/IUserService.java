package com.kq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kq.dto.User;
import com.kq.entity.Application;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
public interface IUserService extends IService<User> {


    public void saveUser(User user);

}
