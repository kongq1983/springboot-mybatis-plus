package com.kq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kq.entity.TArticle;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
public interface ITArticleService extends IService<TArticle> {

    public void add(String id);

    public void add1(String id);

}
