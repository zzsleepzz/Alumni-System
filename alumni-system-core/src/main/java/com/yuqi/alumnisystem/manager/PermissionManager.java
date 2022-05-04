package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.dto.PermissionDto;
import com.yuqi.alumnisystem.entity.Permission;
import com.yuqi.alumnisystem.service.PermissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:53
 */
@Service
public class PermissionManager {

    @Autowired
    private PermissionService permissionService;

    private ModelMapper modelMapper = new ModelMapper();

    public List<PermissionDto> permissions() {
        List<Permission> permissions = permissionService.list();
        List<PermissionDto> dto = permissions.stream().map( x -> modelMapper.map(x, PermissionDto.class)).collect(Collectors.toList());
        return dto;
    }

    public List<PermissionDto> getPermissionsByRoleId(Long roleId) {
        List<Permission> permissions = permissionService.getPermissionsByRoleId(roleId);
        List<PermissionDto> dto = permissions.stream().map( x -> modelMapper.map(x, PermissionDto.class)).collect(Collectors.toList());
        return dto;
    }

}
