package com.hzsun.pm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 平台应用分类
 * </p>
 *
 * @author hzsun
 * @since 2022-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pm_application_category")
public class PmApplicationCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String code;

    private String description;

    private Integer isDeleted;

    private Integer version;

    private Date createTime;

    private Date editTime;


}
