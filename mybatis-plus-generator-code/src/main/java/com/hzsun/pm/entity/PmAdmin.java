package com.hzsun.pm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzsun
 * @since 2022-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pm_admin")
public class PmAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String accountNumber;

    private String password;

    /**
     * 1: 启用  0:停用
     */
    private String status;

    private String mobile;

    private String email;

    private String adminType;

    private Date createTime;

    private Date editTime;


}
