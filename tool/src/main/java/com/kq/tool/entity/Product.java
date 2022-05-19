package com.kq.tool.entity;

/**
 * @author kq
 * @date 2022-05-11 14:42
 * @since 2020-0630
 */
public class Product {

    private Long id;
    private Long tenantId;
    private Long schoolId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", schoolId=" + schoolId +
                '}';
    }
}
