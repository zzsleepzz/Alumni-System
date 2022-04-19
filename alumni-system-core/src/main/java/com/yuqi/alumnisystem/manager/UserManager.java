package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:55
 */
@Service
public class UserManager {

    @Autowired
    private UserService userService;

}
