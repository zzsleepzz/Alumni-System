package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Permission;
import com.yuqi.alumnisystem.mapper.PermissionMapper;
import com.yuqi.alumnisystem.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【permission】的数据库操作Service实现
* @createDate 2022-04-19 19:15:44
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

    @Override
    public List<Permission> getPermissionsByRoleId(Long roleId) {
        QueryWrapper queryWrapper = new QueryWrapper(Permission.builder()
                .roleId(roleId)
                .deleted(false)
                .build());
        return list(queryWrapper);
    }
}




