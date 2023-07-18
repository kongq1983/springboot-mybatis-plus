package com.kq.service.impl;

import com.kq.entity.T1;
import com.kq.enums.SequenceTypeEnum;
import com.kq.mapper.T1Mapper;
import com.kq.mapper.TenantSequenceMapper;
import com.kq.service.ITenantSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: kq
 * @date: 2023-06-27 17:03:32
 * @since: 1.0.0
 * @description:
 */
@Slf4j
@Service
public class TenantSequenceServiceImpl implements ITenantSequenceService {

    @Autowired
    private TenantSequenceMapper tenantSequenceMapper;


    @Autowired
    private ITenantSequenceService tenantSequenceService;

    @Autowired
    private T1Mapper t1Mapper;


    // 注意: mybatis有缓存机制，如果事物隔离级别是REQUIRED，如果参数是一样的，则只会请求存储过程1次
    // 解决方法:
    // 1. 使用随机数参数
    // 2. 使用service方法，该方法事务隔离级别为Propagation.REQUIRES_NEW
    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    @Override
    public Long getTenantNextSeq(Long tenantId, String seqName) {

        Long nextSeq = 0L;

        Map<String,Object> map = new HashMap<>(5);
        map.put("tenantId",tenantId);
        map.put("seqName",seqName);
        map.put("nextSeq",nextSeq);

        try {
            tenantSequenceMapper.getTenantNextSeqMap(map);
        } catch (SQLIntegrityConstraintViolationException e) {
            log.error("获取序列报错------------------",e);
            return this.getTenantNextSeq(tenantId,seqName);
        }

        return (Long)map.get("nextSeq");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void generate(Long tenantId, String seqName) {

        log.info("call generate -------");
//        this.generateNoTransaction(tenantId,seqName);
        this.generateNoTransaction1(SequenceTypeEnum.PERMISSION_SEQ,tenantId,1L);

    }

    @Override
    public void generateNoTransaction(Long tenantId, String seqName) {
        long startTime = System.currentTimeMillis();

        for(int i=0;i<10;i++) {
            if(i==7){
                throw new RuntimeException("i==7");
            }

            Long nextSeq = tenantSequenceService.getTenantNextSeq(tenantId,seqName);

            long endTime = System.currentTimeMillis();

            log.info("generate i={}  nextSeq={}  spendTime={}ms",i,nextSeq,(endTime-startTime));

            List<T1> list = t1Mapper.list();

            log.info("t1.list.size={}   data={}",list.size(),list);
        }


    }


    public void generateNoTransaction1(SequenceTypeEnum sequenceTypeEnum, Long tenantId, Long businessId) {
        long startTime = System.currentTimeMillis();

        for(int i=0;i<10;i++) {
            if(i==7){
                throw new RuntimeException("i==7");
            }

            Long nextSeq = tenantSequenceService.getNextSequence(sequenceTypeEnum,tenantId,businessId);

            long endTime = System.currentTimeMillis();

            log.info("generate i={}  nextSeq={}  spendTime={}ms",i,nextSeq,(endTime-startTime));

            List<T1> list = t1Mapper.list();

            log.info("t1.list.size={}   data={}",list.size(),list);
        }


    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void tenantSequenceWait(Long tenantId, String seqName) throws InterruptedException {
        tenantSequenceMapper.getTableSequence(tenantId,seqName);

        log.info("tenantSequenceWait start!  tenantId={}",tenantId);
        TimeUnit.MINUTES.sleep(10);
        log.info("tenantSequenceWait end!  tenantId={}",tenantId);

    }


    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    @Override
    public Long getNextSequence(SequenceTypeEnum sequenceTypeEnum, Long tenantId) {

        String seqName = sequenceTypeEnum.getKey();

        log.debug("seqName first={}",seqName);

        return this.getCommonNextSeq(tenantId,seqName);

    }

    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    @Override
    public Long getNextSequence(SequenceTypeEnum sequenceTypeEnum, Long tenantId, Long businessId) {

        String seqName = String.format(sequenceTypeEnum.getKey(),businessId);

        log.debug("seqName secnod={}",seqName);

        return this.getCommonNextSeq(tenantId,seqName);
    }

    private Long getCommonNextSeq(Long tenantId, String seqName) {

        Map<String,Object> map = new HashMap<>(5);
        map.put("tenantId",tenantId);
        map.put("seqName",seqName);
        map.put("nextSeq",0L);

        try {
            tenantSequenceMapper.getTenantNextSeqMap(map);
        } catch (SQLIntegrityConstraintViolationException e) {
            log.error("获取序列报错------------------",e);
            return this.getTenantNextSeq(tenantId,seqName);
        }

        return (Long)map.get("nextSeq");
    }


    @Override
    public void callDefaultSequence() {
        long startTime = System.currentTimeMillis();
        log.debug("start callDefaultSequence");

        Map<String,Object> map = new HashMap<>(5);
        map.put("tenantId",0L);
        map.put("seqName","default_launch_seq_name");
        map.put("nextSeq",0L);

        try {
            tenantSequenceMapper.getTenantNextSeqMap(map);
        }catch (Exception e){
            log.error("",e);
        }
        log.debug("e-n-d callDefaultSequence  spentTime={}",(System.currentTimeMillis()-startTime));
    }
}
