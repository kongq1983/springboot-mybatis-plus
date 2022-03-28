package com.kq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 平台应用表
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String shortName;

    private String appCode;

    private String logo;

    private String deployType;

    private String appType;

    private String categoryId;

    private String appDevName;

    private Integer sortNumber;

    private String description;

    @TableField(value="is_using")
//    private Integer isUsing;
    private Integer using;

    private String tokenValidMode;

    private String tokenChgMode;

    private String url;

    private String appId;

    private String appSecret;

    private String appVersion;

    private Integer isDeleted;

    private Integer version;

    private Date createTime;

    private Date editTime;

    private String createUser;

    private String editUser;


}
