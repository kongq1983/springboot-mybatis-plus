package com.kq.controller;

import com.kq.dto.DtoResult;
import com.kq.service.ITenantSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kq
 * @date: 2023-06-27 17:06:54
 * @since: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/tenant/seq")
public class TenantSequenceController {

    @Autowired
    private ITenantSequenceService tenantSequenceService;


    /**
     * 顶层没有@Transactional
     * 下面的service事务
     * @return
     */
    @GetMapping(value = "/get")
    public DtoResult noTransaction() {

        DtoResult result = new DtoResult();

        result.setResult(tenantSequenceService.getTenantNextSeq(100L,"hello"));

        return result;
    }


}
