package com.yuqi.alumnisystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.config.CurrentUserConfig;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.CurrentUser;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.UserManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:38
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private CurrentUserConfig currentUserConfig;

    @GetMapping("/list")
    @ApiOperation("用户列表")
    @CheckPermissions(PermissionEnum.VIEW_ALL_USER)
    public SimpleResponse<Page<UserDto>> list(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        return new SimpleResponse<>(userManager.list(pageNo));
    }

    @GetMapping("/detail")
    @ApiOperation("用户详情")
    @CheckPermissions(PermissionEnum.VIEW_ALL_USER)
    public SimpleResponse<UserDto> detail(Long userId){
        return new SimpleResponse<>(userManager.detail(userId));
    }

    @GetMapping("/info")
    @ApiOperation("查看个人信息")
    public SimpleResponse<CurrentUser> info(){
        return new SimpleResponse<>(currentUserConfig.getCurrentUser());
    }

}
