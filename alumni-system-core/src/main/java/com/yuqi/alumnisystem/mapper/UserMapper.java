package com.yuqi.alumnisystem.mapper;

import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-04-19 19:15:55
* @Entity com.yuqi.alumnisystem.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<UserDto> list();
}




