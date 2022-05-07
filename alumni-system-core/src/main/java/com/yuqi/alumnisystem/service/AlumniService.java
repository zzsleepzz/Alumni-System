package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.entity.Alumni;

/**
* @author Administrator
* @description 针对表【alumni】的数据库操作Service
* @createDate 2022-04-19 19:15:24
*/
public interface AlumniService extends IService<Alumni> {

    Alumni getByIdAndUserId(Long id, Long userId);

    Page<AlumniDto> listByUserId(Integer pageNo, Long userId);

}
