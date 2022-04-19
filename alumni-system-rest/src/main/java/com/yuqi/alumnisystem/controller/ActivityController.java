package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.entity.Activity;
import com.yuqi.alumnisystem.manager.ActivityManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:35
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityManager activityManager;

    @GetMapping("/detail")
    @ApiOperation("活动详情")
    public SimpleResponse<Activity> list(@RequestParam("id") Long id){
        return new SimpleResponse<>(activityManager.detail(id));
    }

}
