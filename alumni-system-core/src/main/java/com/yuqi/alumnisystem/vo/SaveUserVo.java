package com.yuqi.alumnisystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author yuexi.guo
 * @date 2022 14:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveUserVo {

    /**
     * 学校系统ID
     */
    @NotNull
    private Long schoolSystemId;

    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 手机号
     */
    @NotNull
    private String phone;

}
