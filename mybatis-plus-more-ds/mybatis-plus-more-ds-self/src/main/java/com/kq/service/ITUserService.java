package com.kq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kq.entity.TUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
public interface ITUserService extends IService<TUser> {

    public void add(String id);

    public void add1(String id);

}
