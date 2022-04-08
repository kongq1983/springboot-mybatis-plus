package com.kq.jackson.controller;


import com.kq.jackson.dto.AccountDto;
import com.kq.jackson.dto.DtoResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kq
 * @date 2022-04-08 10:31
 * @since 2020-0630
 */

@RestController
public class JscksonEncryptController {


    @GetMapping("/account")
    public DtoResult getAccount(){

        DtoResult result = new DtoResult();

        AccountDto account = new AccountDto();
        account.setPassword("123456");
        account.setUsername("admin");
        account.setName("张小龙");
        account.setMobile("13612340000");
        account.setId(1L);
        account.setEmail("welcome@163.com");
        account.setCardNo("123456789012345678");

        result.setResult(account);

        return result;

    }


    @GetMapping("/account1")
    public AccountDto getAccount1(){


        AccountDto account = new AccountDto();
        account.setPassword("123456");
        account.setUsername("admin");
        account.setName("张小龙");
        account.setMobile("13612340000");
        account.setId(1L);
        account.setEmail("welcome@163.com");
        account.setCardNo("123456789012345678");

        return account;

    }

}
