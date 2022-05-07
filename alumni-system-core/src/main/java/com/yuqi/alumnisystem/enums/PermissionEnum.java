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
    DELETE_OWN_ACTIVITY(310,"删除自己的活动"),
    //4XX-表示捐款
    CREATE_OR_UPDATE_DONATION(400,"创建或修改捐款记录"),
    DELETE_DONATION(410,"删除捐款记录"),
    //5XX-表示留言
    DELETE_ALL_MESSAGE(500,"删除所有留言"),
    DELETE_OWN_MESSAGE(610,"删除自己的留言"),
    //6XX-表示公告
    CREATE_OR_UPDATE_NOTICE(600,"创建或修改公告"),
    DELETE_NOTICE(610,"删除公告"),
    ;
    private final Integer index;

    private final String desc;

}
