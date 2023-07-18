package com.kq.mapper;

import com.kq.dto.TableSequence;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

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
    public void getTenantNextSeq(@Param("tenantId") Long tenantId, @Param("seqName")String seqName,@Param("nextSeq") Long nextSeq);


    /**
     * 获取下一个序列号
     * @param map
     */
    public void getTenantNextSeqMap(Map<String,Object> map) throws SQLIntegrityConstraintViolationException;


    /**
     * 获取TableSequence
     * @param tenantId
     * @param seqName
     * @return
     */
    public TableSequence getTableSequence(@Param("tenantId") Long tenantId, @Param("seqName")String seqName);



}
