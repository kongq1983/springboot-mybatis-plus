package com.kq.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author: kq
 * @date: 2023-06-27 16:45:08
 * @since: 1.0.0
 * @description:
 */
public interface TenantSequenceMapper {

    /**
     * 获取
     * @param tenantId
     * @param seqName
     * @return
     */
    public Long getTenantNextSeq(@Param("tenantId") Long tenantId, @Param("seqName")String seqName);

}
