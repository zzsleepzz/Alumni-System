package com.yuqi.alumnisystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 学校系统ID
     */
    private Long schoolSystemId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否删除：0-否；1-是
     */
    private Integer deleted;

    /**
     * DB创建时间，业务无关
     */
    private Date dbCreatedAt;

    /**
     * DB最后修改时间，业务无关
     */
    private Date dbUpdatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}