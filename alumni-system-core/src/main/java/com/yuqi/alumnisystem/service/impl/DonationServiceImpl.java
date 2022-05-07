package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.constants.PageConstants;
import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.entity.Donation;
import com.yuqi.alumnisystem.mapper.DonationMapper;
import com.yuqi.alumnisystem.service.DonationService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【donation】的数据库操作Service实现
* @createDate 2022-04-19 19:15:27
*/
@Service
public class DonationServiceImpl extends ServiceImpl<DonationMapper, Donation>
    implements DonationService{

    @Override
    public Donation getByIdAndUserId(Long id, Long userId) {
        QueryWrapper queryWrapper = new QueryWrapper(Donation.builder()
                .id(id)
                .userId(userId)
                .deleted(false)
                .build());
        return getOne(queryWrapper);
    }

    @Override
    public Page<DonationDto> listByUserId(Integer pageNo, Long userId) {
        Page<DonationDto> page = new Page<>(pageNo, PageConstants.PAGE_SIZE);
        baseMapper.list(page, userId);
        return page;
    }

}




