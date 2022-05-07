package com.yuqi.alumnisystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.ActivityDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.ActivityManager;
import com.yuqi.alumnisystem.vo.CreateOrUpdateActivityVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 活动
 *
 * @author yuexi.guo
 * @date 2022/4/19 17:35
 */
@Validated
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityManager activityManager;

    @GetMapping("/detail")
    @ApiOperation("活动详情")
    public SimpleResponse<ActivityDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(activityManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("活动列表")
    public SimpleResponse<Page<ActivityDto>> list(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
        return new SimpleResponse<>(activityManager.list(pageNo, null));
    }

    @GetMapping("/listByUserId")
    @ApiOperation("活动列表(用户个人)")
    public SimpleResponse<Page<ActivityDto>> listByUserId(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam("userId") Long userId) {
        return new SimpleResponse<>(activityManager.list(pageNo, userId));
    }

    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改活动")
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateActivityVo vo){
        return new SimpleResponse<>(activityManager.createOrUpdate(vo));
    }

    @GetMapping("/delete")
    @ApiOperation("删除个人活动")
    @CheckPermissions(PermissionEnum.DELETE_OWN_ACTIVITY)
    public SimpleResponse<Boolean> delete(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        return new SimpleResponse<>(activityManager.delete(id, userId));
    }

    @GetMapping("/deleteByAdmin")
    @ApiOperation("删除活动")
    @CheckPermissions(PermissionEnum.DELETE_ALL_ACTIVITY)
    public SimpleResponse<Boolean> deleteByAdmin(@RequestParam("id") Long id) {
        return new SimpleResponse<>(activityManager.delete(id, null));
    }

}
