package com.yuqi.alumnisystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuexi.guo
 * @date 2022 14:06
 */
@Getter
@AllArgsConstructor
public enum RoleEnum implements CommonEnum{
    ADMIN(1,"管理员"),
    USER(2,"用户");

    private final Integer index;

    private final String desc;
}
