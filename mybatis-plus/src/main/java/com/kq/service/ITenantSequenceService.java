package com.kq.service;

import com.kq.enums.SequenceTypeEnum;
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

    public void generateNoTransaction(Long tenantId, String seqName);

    public void tenantSequenceWait(Long tenantId, String seqName) throws InterruptedException;


    /**
     * 获取下一个序列号
     * @param sequenceTypeEnum 枚举
     * @param tenantId  租户ID
     */
    Long getNextSequence(SequenceTypeEnum sequenceTypeEnum, Long tenantId);


    /**
     * 获取下一个序列号
     * @param sequenceTypeEnum 枚举
     * @param tenantId 租户ID
     * @param businessId  业务ID
     */
    Long getNextSequence(SequenceTypeEnum sequenceTypeEnum, Long tenantId, Long businessId);


    /**
     * 启动调用一下存储过程，第一次加载有点慢
     */
    void callDefaultSequence();

}
