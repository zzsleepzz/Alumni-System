package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.dto.RoleDto;
import com.yuqi.alumnisystem.entity.Role;
import com.yuqi.alumnisystem.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:54
 */
@Service
public class RoleManager {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper modelMapper;

    public List<RoleDto> roles() {
        List<Role> roles = roleService.list();
        List<RoleDto> dto = roles.stream().map(x -> modelMapper.map(x, RoleDto.class)).collect(Collectors.toList());
        return dto;
    }

}
