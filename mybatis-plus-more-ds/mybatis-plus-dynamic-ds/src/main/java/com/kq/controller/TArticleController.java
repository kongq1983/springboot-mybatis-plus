package com.kq.controller;


import com.kq.service.ITArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @GetMapping("/add")
    public Map<String,Object> get(@RequestParam("id") String id) {

        Map<String,Object> map = new HashMap<>();

        articleService.add(id);

        map.put("id",id);
        return map;

    }


}
