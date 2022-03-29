package com.kq.app.dto;

import com.github.crab2died.annotation.ExcelField;
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
 * @since 2022-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmApplicationDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    @ExcelField(title = "应用名称", order = 1)
    private String name;

    @ExcelField(title = "应用名称", order = 2)
    private String shortName;

    @ExcelField(title = "应用编码", order = 1)
    private String appCode;

    @ExcelField(title = "应用LOGO", order = 9)
    private String logo;

    @ExcelField(title = "部署方式", order = 1)
    private String deployType;

    @ExcelField(title = "应用类型", order = 1)
    private String appType;

    private String categoryId;

    private String appDevName;

    @ExcelField(title = "应用排序", order = 1)
    private Integer sortNumber;

    private String description;

    private Integer isUsing;

    private String tokenValidMode;

    private String tokenChgMode;

    @ExcelField(title = "应用路径", order = 8)
    private String url;

    @ExcelField(title = "AppID", order = 6)
    private String appId;

    @ExcelField(title = "AppSecret", order = 7)
    private String appSecret;

    private String appVersion;

    private Integer isDeleted;

    private Integer version;

    private Date createTime;

    private Date editTime;

    private String createUser;

    private String editUser;


}
