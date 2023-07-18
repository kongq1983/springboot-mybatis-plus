package com.kq.dto;

/**
 * @author: kq
 * @date: 2023-07-04 15:57:25
 * @since: 1.0.0
 * @description:
 */
public class TableSequence {

    private Long tenantId;

    private String seqName;

    private Long currentVal;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public Long getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(Long currentVal) {
        this.currentVal = currentVal;
    }

    @Override
    public String toString() {
        return "TableSequence{" +
                "tenantId=" + tenantId +
                ", seqName='" + seqName + '\'' +
                ", currentVal=" + currentVal +
                '}';
    }
}
