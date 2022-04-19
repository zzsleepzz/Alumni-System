package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.entity.Activity;
import com.yuqi.alumnisystem.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:49
 */
@Service
public class ActivityManager {

    @Autowired
    private ActivityService activityService;


    public Activity detail(Long id){
        return activityService.getById(id);
    }

}
