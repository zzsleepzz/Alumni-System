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
    //1XX-表示用户模块
    VIEW_ALL_USER(100, "查看所有用户"),
    //2XX-表示校友模块
    CREATE_OR_UPDATE_ALUMNI(200, "创建或修改校友信息"),
    DELETE_ALUMNI(210, "删除校友信息"),
    //3XX-表示活动模块
    DELETE_ALL_ACTIVITY(300,"删除所有活动"),
    DELETE_OWN_ACTIVITY(310,"删除自己的活动");

    private final Integer index;

    private final String desc;

}
