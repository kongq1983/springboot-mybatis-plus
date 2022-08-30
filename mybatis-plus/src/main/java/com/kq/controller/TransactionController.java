package com.kq.controller;

import com.kq.dto.DtoResult;

import com.kq.dto.User;
import com.kq.entity.Application;
import com.kq.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author kq
 * @date 2022-08-29 15:19
 * @since 2020-0630
 */
@RestController
@RequestMapping("/t")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;


    /**
     * 顶层没有@Transactional
     * 下面的service事务
     * @return
     */
    @GetMapping(value = "/no")
    public DtoResult noTransaction() {

        DtoResult result = new DtoResult();

        try{
            transactionService.saveNoTransaction(this.getApplication(),this.getUser());
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(e.getMessage());
        }

        return result;
    }

    /**
     * 顶层没有@Transactional
     * 下面的service事务
     * @return
     */
    @GetMapping(value = "/no1")
    public DtoResult noTransaction1() {

        DtoResult result = new DtoResult();

        try{
            transactionService.saveNoTransaction1(this.getApplication(),this.getUser());
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(e.getMessage());
        }

        return result;
    }


    /**
     * 顶层没有@Transactional
     * 下面的每个service方法有事务
     * @return
     */
    @GetMapping(value = "/no2")
    public DtoResult noTransaction2() {

        DtoResult result = new DtoResult();

        try{
            transactionService.saveNoTransaction2(this.getApplication(),this.getUser());
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(e.getMessage());
        }

        return result;
    }

    @GetMapping(value = "/no3")
    public DtoResult noTransaction3() {

        DtoResult result = new DtoResult();

        try{
            transactionService.saveNoTransaction3(this.getApplication(),this.getUser());
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(e.getMessage());
        }

        return result;
    }

    private User getUser() {
        User user = new User();
        user.setAge(18);
        user.setName("12345678901234567890123456789012345");
        return user;
    }

    private Application getApplication() {
        Application application = new Application();
        application.setName("app1");
        application.setCreateTime(new Date());
        application.setAppType("1");
        application.setAppCode("01");
        return application;
    }


    @GetMapping(value = "/yes")
    public DtoResult yesTransaction() {

        DtoResult result = new DtoResult();

        try{
            transactionService.saveWithTransaction(this.getApplication(),this.getUser());
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(e.getMessage());
        }

        return result;
    }


}
