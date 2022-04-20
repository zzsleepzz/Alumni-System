package com.yuqi.alumnisystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuexi.guo
 * @date 2022/4/20 10:08
 */
@Getter
@AllArgsConstructor
public enum PermissionEnum implements CommonEnum{
    //01XX-表示用户模块
    VIEW_ALL_USER(0100, "查看所有用户的信息")
    //02XX-表示校友模块
    ;

    private final Integer index;

    private final String desc;

}
