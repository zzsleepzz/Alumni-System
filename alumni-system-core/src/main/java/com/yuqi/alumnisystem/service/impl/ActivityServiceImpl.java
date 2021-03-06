package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Activity;
import com.yuqi.alumnisystem.service.ActivityService;
import com.yuqi.alumnisystem.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【activity】的数据库操作Service实现
* @createDate 2022-04-19 19:15:12
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




