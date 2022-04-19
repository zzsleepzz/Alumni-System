package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:53
 */
@Service
public class PermissionManager {

    @Autowired
    private PermissionService permissionService;

}
