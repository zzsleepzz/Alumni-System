package com.yuqi.alumnisystem.aspects;

import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.config.CurrentUserConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 校验权限点切面
 *
 * @author yuexi.guo
 * @date 2022/4/20 10:21
 */
@Aspect
@Component
public class CheckPermissionsAspect {

    @Pointcut("@annotation(com.yuqi.alumnisystem.annotations.CheckPermissions)")
    public void check() {

    }

    private final CurrentUserConfig currentUserConfig;

    @Autowired
    public CheckPermissionsAspect(CurrentUserConfig currentUserConfig) {
        this.currentUserConfig = currentUserConfig;
    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        // 拿到方法定义的注解信息
        CheckPermissions annotation = objMethod.getDeclaredAnnotation(CheckPermissions.class);
        if (Objects.isNull(annotation)) {
            return;
        }
        currentUserConfig.checkPermissions(currentUserConfig.getCurrentUser(), annotation.value(), true);
    }

}
