package com.kq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.entity.TArticle;
import com.kq.entity.TUser;
import com.kq.mapper.article.TArticleMapper;
import com.kq.service.ITArticleService;
import com.kq.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
@Service
public class TArticleServiceImpl extends ServiceImpl<TArticleMapper, TArticle> implements ITArticleService {

    @Autowired
    private ITUserService userService;

    @Override
    public void add(String id) {

        TArticle article = new TArticle();
        article.setName("articel:"+id);
        article.setIsDeleted(0);

        this.save(article);


        TUser user = new TUser();
        user.setName("user:"+id);
        user.setIsDeleted(0);

        userService.save(user);

    }
}
