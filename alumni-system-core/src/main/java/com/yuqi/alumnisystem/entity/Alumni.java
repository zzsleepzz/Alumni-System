package com.yuqi.alumnisystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName alumni
 */
@TableName(value ="alumni")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumni implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 优秀校友名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片url
     */
    private String url;

    /**
     * 是否删除：0-否；1-是
     */
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