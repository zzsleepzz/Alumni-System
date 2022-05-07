package com.yuqi.alumnisystem.service;

import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.entity.Alumni;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【alumni】的数据库操作Service
* @createDate 2022-04-19 19:15:24
*/
public interface AlumniService extends IService<Alumni> {

    Alumni getByIdAndUserId(Long id, Long userId);

    List<AlumniDto> listByUserId(Long userId);

}
