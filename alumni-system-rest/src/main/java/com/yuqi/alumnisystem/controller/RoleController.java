package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.manager.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:38
 */
@RestController
public class RoleController {

    @Autowired
    private RoleManager roleManager;

}
