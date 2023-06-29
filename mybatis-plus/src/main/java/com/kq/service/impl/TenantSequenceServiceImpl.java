package com.kq.service.impl;

import com.kq.mapper.TenantSequenceMapper;
import com.kq.service.ITenantSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kq
 * @date: 2023-06-27 17:03:32
 * @since: 1.0.0
 * @description:
 */
@Service
public class TenantSequenceServiceImpl implements ITenantSequenceService {

    @Autowired
    private TenantSequenceMapper tenantSequenceMapper;


    @Override
    public Long getTenantNextSeq(Long tenantId, String seqName) {

        Long nextSeq = 0L;

//        tenantSequenceMapper.getTenantNextSeq(tenantId,seqName,nextSeq);

        Map<String,Object> map = new HashMap<>();
        map.put("tenantId",tenantId);
        map.put("seqName",seqName);
        map.put("nextSeq",nextSeq);

        tenantSequenceMapper.getTenantNextSeqMap(map);

        return (Long)map.get("nextSeq");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void generate(Long tenantId, String seqName) {

        for(int i=0;i<10;i++) {
            if(i==7){
                throw new RuntimeException("i==7");
            }
        }

    }
}
