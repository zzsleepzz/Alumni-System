package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.User;
import com.yuqi.alumnisystem.service.UserService;
import com.yuqi.alumnisystem.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-04-19 19:15:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




