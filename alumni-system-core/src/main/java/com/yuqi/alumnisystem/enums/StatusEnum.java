package com.yuqi.alumnisystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码枚举
 *
 * @author yuexi.guo
 * @date 2022/4/19 19:26
 */
@Getter
@AllArgsConstructor
public enum StatusEnum implements CommonEnum {
    SUCCESS(0, "成功"),

    /**
     * 系统错误码
     */
    DATA_CHANGED(10, "数据已被修改"),
    DATA_NOT_EXIST(11, "数据不存在"),
    DATA_WRONG(12, "未知错误"),
    INVALID_DATA(13, "数据无效"),
    PARAM_ERROR(14, "参数异常"),
    ERROR_NOT_FOUND(15, "资源不存在"),
    PARAM_MISS(16, "参数[s%]错误"),
    DATA_MAPPER_FAILED(17, "数据转化失败"),
    JSON_CONVERT_FAILED(18, "Json转换失败"),
    REST_CLIENT_ERROR(19, "feign请求调用失败"),
    NO_PERMISSION(20, "当前用户没有操作权限"),
    NO_SYSTEM_VERSION_PERMISSION(21, "当前系统版本没有操作权限"),
    NEED_OAUTH(-9999, "未获取到您的登录信息，请尝试重新登录后再进行访问");

    private final Integer index;

    private final String desc;
}
