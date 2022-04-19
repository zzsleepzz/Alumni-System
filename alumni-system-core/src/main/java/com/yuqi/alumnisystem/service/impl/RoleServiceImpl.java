package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Role;
import com.yuqi.alumnisystem.service.RoleService;
import com.yuqi.alumnisystem.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【role】的数据库操作Service实现
* @createDate 2022-04-19 19:15:50
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




