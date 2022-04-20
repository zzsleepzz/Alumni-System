package com.yuqi.alumnisystem.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuqi.alumnisystem.constants.GateWayConstants;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.CurrentUser;
import com.yuqi.alumnisystem.entity.User;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.UserService;
import com.yuqi.alumnisystem.util.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:55
 */
@Service
public class UserManager {

    @Autowired
    private UserService userService;

    public UserDto detail(Long schoolSystemId, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(User.builder()
                .schoolSystemId(schoolSystemId)
                .password(password)
                .deleted(false)
                .build());
        User user = userService.getOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        UserDto userDto = UserDto.builder()
                .schoolSystemId(user.getSchoolSystemId())
                .username(user.getUsername())
                .phone(user.getPhone())
                .build();
        CurrentUser currentUser = CurrentUser.builder()
                .permissions(new String[]{PermissionEnum.VIEW_ALL_USER.getIndex().toString()})
                .build();
        ServletUtils.getHttpServletRequest().getSession().setAttribute(GateWayConstants.HEADER_CURRENTUSER, currentUser);
        return userDto;
    }

}
