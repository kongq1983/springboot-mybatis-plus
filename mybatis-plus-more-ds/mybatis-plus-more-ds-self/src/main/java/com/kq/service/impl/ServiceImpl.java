package com.kq.service.impl;

import com.kq.service.IService;
import com.kq.service.ITArticleService;
import com.kq.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kq
 * @date 2022-11-24 16:16
 * @since 2020-0630
 */
@Service
public class ServiceImpl implements IService {

    // 注意：默认是article_ds

    @Autowired
    private ITArticleService articleService;

    @Autowired
    private ITUserService userService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(String id) {

        articleService.add(id);  // 不会持久化，事务会回滚？ why?  因为默认datasource=article_ds
        userService.add(id); // 报错

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add1(String id) {
        userService.add1(id);  // 会持久化      当前spring默认datasource=article_ds  (当前ds没被spring接管)

        articleService.add1(id);   // 报错
    }
}
