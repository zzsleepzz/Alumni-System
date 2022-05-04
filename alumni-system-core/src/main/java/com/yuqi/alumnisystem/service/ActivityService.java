package com.yuqi.alumnisystem.service;

import com.yuqi.alumnisystem.dto.ActivityDto;
import com.yuqi.alumnisystem.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【activity】的数据库操作Service
* @createDate 2022-04-19 19:15:12
*/
public interface ActivityService extends IService<Activity> {

    List<ActivityDto> listByUserId(Long userId);

    Activity getByIdAndUserId(Long id, Long userId);
}
