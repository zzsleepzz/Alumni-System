package com.yuqi.alumnisystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022/4/20 11:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentUser {

    /**
     * 主键ID
     */
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
     * 手机号
     */
    private String phone;

    /**
     * 权限点
     */
    private String[] permissions;

}
