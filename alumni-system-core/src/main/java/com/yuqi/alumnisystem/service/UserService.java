package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.User;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-04-19 19:15:55
*/
public interface UserService extends IService<User> {

    User getBySystemIdAndPassword(Long schoolSystemId, String password);

    Page<UserDto> listAll(Integer pageNo);
}
