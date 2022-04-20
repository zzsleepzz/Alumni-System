package com.yuqi.alumnisystem.config;

import com.yuqi.alumnisystem.constants.GateWayConstants;
import com.yuqi.alumnisystem.entity.CurrentUser;
import com.yuqi.alumnisystem.entity.User;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

/**
 * 当前用户相关处理
 * @author yuexi.guo
 * @date 2022/4/20 11:07
 */
@Slf4j
@Component
public class CurrentUserConfig {

    /**
     * 获取session id
     *
     * @return session id
     */
    public String getSessionId() {
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        return request.getHeader(GateWayConstants.SESSION_ID);
    }

    /**
     * 获取CurrentUser
     * @return CurrentUser
     */
    public CurrentUser getCurrentUser() {
        //todo 将session里存的对象改成json
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        //获取用户登录信息
        CurrentUser currentUser = null;
        currentUser = (CurrentUser) ServletUtils.getHttpServletRequest().getSession().getAttribute(GateWayConstants.HEADER_CURRENTUSER);
        if (Objects.isNull(currentUser)) {
            throw new BusinessException(StatusEnum.NEED_OAUTH);
        }
        //return new CurrentUser(new String[]{PermissionEnum.VIEW_ALL_USER.getIndex().toString()});
        return currentUser;
    }

    /**
     * 校验用户的权限点是否满足条件
     *
     * @param currentUser            当前登录用户
     * @param needPermissions        需要的权限点
     * @param throwBusinessException 校验不通过时抛出业务异常
     */
    public boolean checkPermissions(CurrentUser currentUser, PermissionEnum[] needPermissions, boolean throwBusinessException) {
        if (Objects.isNull(needPermissions) || needPermissions.length == 0) {
            return true;
        }
        if (Objects.nonNull(currentUser.getPermissions()) && currentUser.getPermissions().length > 0) {
            for (PermissionEnum needPermission : needPermissions) {
                if (Arrays.stream(currentUser.getPermissions()).anyMatch(x -> needPermission.getIndex().toString().equals(x))) {
                    return true;
                }
            }
        }
        if (throwBusinessException) {
            throw new BusinessException(StatusEnum.NO_PERMISSION);
        }
        return false;
    }
}
