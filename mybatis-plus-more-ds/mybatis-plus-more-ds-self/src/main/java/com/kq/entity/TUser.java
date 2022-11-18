package com.kq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author kq
 * @since 2022-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer isDeleted;

    private Date createTime;

    private Date editTime;

    private Long createUser;

    private Long editUser;


}
