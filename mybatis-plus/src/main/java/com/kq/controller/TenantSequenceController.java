package com.kq.controller;

import com.kq.dto.DtoResult;
import com.kq.service.ITenantSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * http://localhost:10000/tenant/seq/get?tenantId=100
     * @return
     */
    @GetMapping(value = "/get")
    public DtoResult noTransaction(@RequestParam(value = "tenantId") Long tenantId) {

        DtoResult result = new DtoResult();

        result.setResult(tenantSequenceService.getTenantNextSeq(tenantId,"hello"));

        return result;
    }


    /**
     * http://localhost:10000/tenant/seq/gen?tenantId=100
     * @return
     */
    @GetMapping(value = "/gen")
    public DtoResult gen(@RequestParam(value = "tenantId") Long tenantId,
                         @RequestParam(value = "sw") Integer sw) {

        DtoResult result = new DtoResult();

        try {
            if (sw != null && sw.intValue() == 1) {
                tenantSequenceService.generate(tenantId, "hello");
            } else {
                tenantSequenceService.generateNoTransaction(tenantId, "hello");
            }

        }catch (Exception e){
            result.setCode("-1");
            result.setResult(e.getMessage());
        }
        return result;
    }


}
