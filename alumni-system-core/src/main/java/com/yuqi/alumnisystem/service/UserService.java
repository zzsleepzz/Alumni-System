package com.yuqi.alumnisystem.service;

import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-04-19 19:15:55
*/
public interface UserService extends IService<User> {

    User getBySystemIdAndPassword(Long schoolSystemId, String password);

    List<UserDto> listAll();
}
