package com.kq.controller;

import com.kq.dto.DtoResult;
import com.kq.service.ITenantSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: kq
 * @date: 2023-06-27 17:06:54
 * @since: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/concurrent/tenant/seq")
public class TenantSequenceConcurrentController {

    @Autowired
    private ITenantSequenceService tenantSequenceService;

    BlockingQueue blockingQueue = new LinkedBlockingQueue();

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8,8,3, TimeUnit.SECONDS,blockingQueue);


    /**
     * http://localhost:10000/concurrent/tenant/seq/get?tenantId=100
     * @return
     */
    @GetMapping(value = "/get")
    public DtoResult noTransaction(@RequestParam(value = "tenantId") Long tenantId) throws InterruptedException, ExecutionException {

        DtoResult result = new DtoResult();

        Collection<Callable<Long>> list = new ArrayList<>();

        for(int i=0;i<20;i++) {
            Callable<Long> callable = ()-> {
                return tenantSequenceService.getTenantNextSeq(tenantId,"hello");
            };
            list.add(callable);
        }

        List<Future<Long>> futures = poolExecutor.invokeAll(list);

       List<Long> idList = new ArrayList<>();

       for(Future<Long> f : futures) {
           idList.add(f.get());
       }

        Collections.sort(idList);

        result.setResult(idList);
        return result;
    }


    /**
     * http://localhost:10000/concurrent/tenant/seq/wait?tenantId=108
     * @param tenantId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/wait")
    public DtoResult waitFor(@RequestParam(value = "tenantId") Long tenantId) throws Exception {

        DtoResult result = new DtoResult();

        tenantSequenceService.tenantSequenceWait(tenantId,"hello");

        return result;
    }

}
