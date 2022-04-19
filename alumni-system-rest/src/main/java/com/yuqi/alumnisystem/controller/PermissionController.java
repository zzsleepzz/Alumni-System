package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.manager.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:38
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionManager permissionManager;

}
