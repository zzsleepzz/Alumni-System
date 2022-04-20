package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.entity.Activity;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.ActivityManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @CheckPermissions({PermissionEnum.VIEW_ALL_USER})
    public SimpleResponse<Activity> list(@RequestParam("id") Long id, HttpServletRequest request){
        System.out.println(request.getSession());
        return new SimpleResponse<>(activityManager.detail(id));
    }

}
