package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.constants.GateWayConstants;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.CurrentUser;
import com.yuqi.alumnisystem.entity.Permission;
import com.yuqi.alumnisystem.entity.User;
import com.yuqi.alumnisystem.enums.RoleEnum;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.PermissionService;
import com.yuqi.alumnisystem.service.UserService;
import com.yuqi.alumnisystem.util.ServletUtils;
import com.yuqi.alumnisystem.vo.SaveUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:55
 */
@Service
public class UserManager {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    public CurrentUser login(Long schoolSystemId, String password) {
        User user = userService.getBySystemIdAndPassword(schoolSystemId, password);
        if (Objects.isNull(user)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
//        UserDto userDto = UserDto.builder()
//                .schoolSystemId(user.getSchoolSystemId())
//                .username(user.getUsername())
//                .phone(user.getPhone())
//                .build();
        List<Permission> permissions = permissionService.getPermissionsByRoleId(user.getRoleId());
        String[] permissionsArray = new String[permissions.size()];
        permissionsArray = permissions.stream().map(x -> x.getPermissionValue().toString()).collect(Collectors.toList()).toArray(permissionsArray);
        //创建currentUser并存入session
        CurrentUser currentUser = CurrentUser.builder()
                .id(user.getId())
                .permissions(permissionsArray)
                .build();
        ServletUtils.getHttpServletRequest().getSession().setAttribute(GateWayConstants.HEADER_CURRENTUSER, currentUser);
        return currentUser;
    }

    public Boolean logout(){
        HttpSession session = ServletUtils.getHttpServletRequest().getSession();
        if (Objects.isNull(session)) {
            throw new BusinessException(StatusEnum.NEED_OAUTH);
        }
        session.invalidate();
        return true;
    }


    public List<UserDto> list() {
        return userService.listAll();
    }

    public UserDto detail(Long userId) {
        User user = userService.getById(userId);
        UserDto userDto = UserDto.builder()
                .schoolSystemId(user.getSchoolSystemId())
                .username(user.getUsername())
                .phone(user.getPhone())
                .build();
        return userDto;
    }

    public Long save(SaveUserVo vo) {
        //todo 调用第三方api判断是否是本校学生
        User user = User.builder()
                .schoolSystemId(vo.getSchoolSystemId())
                .roleId(Long.parseLong(RoleEnum.USER.getIndex().toString()))
                .username(vo.getUsername())
                .password(vo.getPassword())
                .phone(vo.getPhone())
                .build();
        if (!userService.save(user)) {
            throw new BusinessException(StatusEnum.CREATE_USER_FAIL);
        }
        return user.getId();
    }
}
