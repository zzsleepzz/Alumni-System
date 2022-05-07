package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.entity.Donation;

/**
* @author Administrator
* @description 针对表【donation】的数据库操作Service
* @createDate 2022-04-19 19:15:27
*/
public interface DonationService extends IService<Donation> {

    Donation getByIdAndUserId(Long id, Long userId);

    Page<DonationDto> listByUserId(Integer pageNo, Long userId);

}
