package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.dto.PermissionDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.manager.PermissionManager;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:38
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private final PermissionManager permissionManager = new PermissionManager();

    @GetMapping("/permissions")
    @ApiModelProperty("所有权限")
    public SimpleResponse<List<PermissionDto>> permissions() {
        return new SimpleResponse<>(permissionManager.permissions());
    }

    @GetMapping("/rolePermission")
    @ApiModelProperty("角色权限")
    public SimpleResponse<List<PermissionDto>> rolePermission(@RequestParam("roleId") Long roleId) {
        return new SimpleResponse<>(permissionManager.getPermissionsByRoleId(roleId));
    }

}
