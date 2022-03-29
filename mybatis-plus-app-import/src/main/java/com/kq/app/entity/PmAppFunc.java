package com.kq.app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 平台应用功能
 * </p>
 *
 * @author hzsun
 * @since 2022-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pm_app_func")
public class PmAppFunc implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String applicationId;

    private String name;

    private String funcCode;

    private String funcUrl;

    private String description;

    private Integer sortNumber;

    private Integer isDeleted;

    private Integer version;

    private Date createTime;

    private Date editTime;

    private String createUser;

    private String editUser;


}
