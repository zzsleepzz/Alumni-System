package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.constants.PageConstants;
import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.entity.Alumni;
import com.yuqi.alumnisystem.mapper.AlumniMapper;
import com.yuqi.alumnisystem.service.AlumniService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【alumni】的数据库操作Service实现
* @createDate 2022-04-19 19:15:24
*/
@Service
public class AlumniServiceImpl extends ServiceImpl<AlumniMapper, Alumni>
    implements AlumniService{

    @Override
    public Alumni getByIdAndUserId(Long id, Long userId) {
        QueryWrapper<Alumni> queryWrapper = new QueryWrapper<>(Alumni.builder()
                .id(id)
                .userId(userId)
                .deleted(false)
                .build());
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<AlumniDto> listByUserId(Integer pageNo, Long userId) {
        Page<AlumniDto> page = new Page<>(pageNo, PageConstants.PAGE_SIZE);
        baseMapper.listByUserId(page, userId);
        return page;
    }
}




