package com.kq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.entity.TUser;
import com.kq.mapper.user.TUserMapper;
import com.kq.service.ITUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(String id) {

        TUser user = new TUser();
//        user.setName("user:"+id);

        StringBuilder str = new StringBuilder();
        str.append("user:");

        for(int i=0;i<64;i++){
            str.append("i");
        }

        str.append(id);

        user.setName(str.toString());
        user.setIsDeleted(0);

        this.save(user);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add1(String id) {
        TUser user = new TUser();
//        user.setName("user:"+id);

        StringBuilder str = new StringBuilder();
        str.append("user:");

        str.append(id);

        user.setName(str.toString());
        user.setIsDeleted(0);

        this.save(user);
    }
}
