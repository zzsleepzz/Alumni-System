package com.yuqi.alumnisystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.entity.Donation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【donation】的数据库操作Mapper
* @createDate 2022-04-19 19:15:27
* @Entity com.yuqi.alumnisystem.entity.Donation
*/
public interface DonationMapper extends BaseMapper<Donation> {

    List<DonationDto> list(@Param("page") Page<DonationDto> page, @Param("userId") Long userId);
}




