package com.yuqi.alumnisystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName role
 */
@TableName(value ="role")
@Data
@Builder
public class Role implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 是否删除：0-否；1-是
     */
    @TableLogic
    private Boolean deleted;

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