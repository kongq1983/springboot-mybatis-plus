package com.kq.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author: kq
 * @date: 2023-06-27 16:58:06
 * @since: 1.0.0
 * @description:
 */
public interface ITenantSequenceService {


    public Long getTenantNextSeq(Long tenantId, String seqName);


    public void generate(Long tenantId, String seqName);

}
