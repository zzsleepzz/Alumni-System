package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.constants.PageConstants;
import com.yuqi.alumnisystem.dto.UserDto;
import com.yuqi.alumnisystem.entity.User;
import com.yuqi.alumnisystem.mapper.UserMapper;
import com.yuqi.alumnisystem.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-04-19 19:15:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User getBySystemIdAndPassword(Long schoolSystemId, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(User.builder()
                .schoolSystemId(schoolSystemId)
                .password(password)
                .deleted(false)
                .build());
        return getOne(queryWrapper);
    }

    @Override
    public Page<UserDto> listAll(Integer pageNo) {
        Page<UserDto> page = new Page<>(pageNo, PageConstants.PAGE_SIZE);
        baseMapper.list(page);
        return page;
    }
}




