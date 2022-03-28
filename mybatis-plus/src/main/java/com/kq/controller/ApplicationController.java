package com.kq.controller;


import com.kq.dto.DtoResult;
import com.kq.dto.User;
import com.kq.entity.Application;
import com.kq.mapper.ApplicationMapper;
import com.kq.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 平台应用表 前端控制器
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private ApplicationMapper applicationMapper;

    @RequestMapping(value = "/get",method= {RequestMethod.GET,RequestMethod.POST})
    public DtoResult get(@RequestParam(value = "username") String username,
                         @RequestParam(value = "ids",required = false) String[] ids

//            @RequestParam(value = "phone") String phone,
//                                 @RequestParam(value = "type") Integer type
    ) {

        DtoResult result = new DtoResult();

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("ids",ids);

        result.setResult(map);

        return result;
    }


    @RequestMapping(value = "/add",method= {RequestMethod.GET,RequestMethod.POST})
    public DtoResult add() {


        Application application = new Application();
//        application.setIsUsing(1);
        application.setUsing(1);
        application.setName("test");
        application.setId(UUID.randomUUID().toString());
        application.setAppCode("100");
        application.setAppType("1");

        applicationMapper.insert(application);


        DtoResult result = new DtoResult();
        result.setResult(application);

        return result;
    }

    @RequestMapping(value = "/list",method= {RequestMethod.POST})
    public DtoResult list() {

        DtoResult result = new DtoResult();
        result.setResult(this.applicationMapper.selectList(null));

        return result;
    }


}
