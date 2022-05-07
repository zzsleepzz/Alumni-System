package com.yuqi.alumnisystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.User;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-04-19 19:15:55
* @Entity com.yuqi.alumnisystem.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    Page<UserDto> list(@Param("page") Page<UserDto> page);
}




