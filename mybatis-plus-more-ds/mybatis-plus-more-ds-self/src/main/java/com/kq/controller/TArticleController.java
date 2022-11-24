package com.kq.controller;


import com.kq.entity.TArticle;
import com.kq.entity.TUser;
import com.kq.mapper.article.TArticleMapper;
import com.kq.mapper.user.TUserMapper;
import com.kq.service.IService;
import com.kq.service.ITArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
@RestController
@RequestMapping("/article")
public class TArticleController {

    @Autowired
    private ITArticleService articleService;

    @Autowired
    private TArticleMapper articleMapper;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private IService service;


    @GetMapping("/add")
    public Map<String,Object> get(@RequestParam("id") String id) {

        Map<String,Object> map = new HashMap<>();
        service.add(id);
//        this.add(id);
        map.put("id",id);
        return map;

    }


    @GetMapping("/add1")
    public Map<String,Object> addOne(@RequestParam("id") String id) {

        Map<String,Object> map = new HashMap<>();
        service.add1(id);
//        this.add(id);
        map.put("id",id);
        return map;

    }

    public void add(String id) {

        TArticle article = new TArticle();
        article.setName("articel:"+id);
        article.setIsDeleted(0);

        articleMapper.insert(article);


        TUser user = new TUser();
        user.setName("user:"+id);
        user.setIsDeleted(0);

        userMapper.insert(user);

    }


}
