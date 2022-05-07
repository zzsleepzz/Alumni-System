package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.entity.Donation;

import java.util.List;

/**
* @author Administrator
* @description 针对表【donation】的数据库操作Service
* @createDate 2022-04-19 19:15:27
*/
public interface DonationService extends IService<Donation> {

    Donation getByIdAndUserId(Long id, Long userId);

    List<DonationDto> listByUserId(Long userId);

}
