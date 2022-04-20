package com.yuqi.alumnisystem.annotations;

import com.yuqi.alumnisystem.enums.PermissionEnum;

import java.lang.annotation.*;

/**
 * @author yuexi.guo
 * @date 2022/4/20 10:07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CheckPermissions {

    PermissionEnum[] value() default {};

}
