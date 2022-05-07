package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.entity.CurrentUser;
import com.yuqi.alumnisystem.manager.UserManager;
import com.yuqi.alumnisystem.vo.SaveUserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账号
 *
 * @author yuexi.guo
 * @date 2022 14:41
 */
@Validated
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/register")
    @ApiOperation("注册")
    public SimpleResponse<Long> register(SaveUserVo vo) {
        return new SimpleResponse<>(userManager.save(vo));
    }

    @GetMapping("/login")
    @ApiOperation("登录")
    public SimpleResponse<CurrentUser> login(Long schoolSystemId, String password) {
        return new SimpleResponse<>(userManager.login(schoolSystemId, password));
    }

    @GetMapping("/logout")
    @ApiOperation("登出")
    public SimpleResponse<Boolean> logout() {
        return new SimpleResponse<>(userManager.logout());
    }

}
