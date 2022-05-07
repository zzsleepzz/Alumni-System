package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.DonationManager;
import com.yuqi.alumnisystem.vo.CreateOrUpdateDonationVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 捐款
 * @author yuexi.guo
 * @date 2022/4/19 17:36
 */
@Validated
@RestController
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private DonationManager donationManager;

    @GetMapping("/detail")
    @ApiOperation("公告详情")
    public SimpleResponse<DonationDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(donationManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("公告列表")
    public SimpleResponse<List<DonationDto>> list(@RequestParam(value = "userId", required = false) Long userId) {
        return new SimpleResponse<>(donationManager.list(userId));
    }


    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改公告")
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateDonationVo vo){
        return new SimpleResponse<>(donationManager.createOrUpdate(vo));
    }

    @GetMapping("/deleteByAdmin")
    @ApiOperation("删除公告")
    @CheckPermissions(PermissionEnum.DELETE_ALL_ACTIVITY)
    public SimpleResponse<Boolean> deleteByAdmin(@RequestParam("id") Long id) {
        return new SimpleResponse<>(donationManager.delete(id, null));
    }

}
