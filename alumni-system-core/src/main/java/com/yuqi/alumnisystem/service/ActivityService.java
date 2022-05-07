package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.ActivityDto;
import com.yuqi.alumnisystem.entity.Activity;

/**
* @author Administrator
* @description 针对表【activity】的数据库操作Service
* @createDate 2022-04-19 19:15:12
*/
public interface ActivityService extends IService<Activity> {

    Page<ActivityDto> listByUserId(Integer pageNo, Long userId);

    Activity getByIdAndUserId(Long id, Long userId);
}
