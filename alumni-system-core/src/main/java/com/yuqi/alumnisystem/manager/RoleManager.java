package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:54
 */
@Service
public class RoleManager {

    @Autowired
    private RoleService roleService;

}
