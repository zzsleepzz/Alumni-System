package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.dto.RoleDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.manager.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:38
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleManager roleManager;

    @GetMapping("/roles")
    public SimpleResponse<List<RoleDto>> roles() {
        return new SimpleResponse<>(roleManager.roles());
    }

}
