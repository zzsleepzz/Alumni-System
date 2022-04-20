package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.manager.UserManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/login")
    @ApiOperation("登录")
    public SimpleResponse<UserDto> login(Long schoolId, String password) {
        return new SimpleResponse<>(userManager.detail(schoolId, password));
    }

}
