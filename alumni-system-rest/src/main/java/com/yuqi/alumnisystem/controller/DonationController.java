package com.yuqi.alumnisystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    @ApiOperation("捐款详情")
    public SimpleResponse<DonationDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(donationManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("捐款列表")
    public SimpleResponse<Page<DonationDto>> list(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "userId", required = false) Long userId) {
        return new SimpleResponse<>(donationManager.list(pageNo, userId));
    }


    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改捐款记录")
    @CheckPermissions(PermissionEnum.CREATE_OR_UPDATE_DONATION)
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateDonationVo vo){
        return new SimpleResponse<>(donationManager.createOrUpdate(vo));
    }

    @GetMapping("/deleteByAdmin")
    @ApiOperation("删除捐款记录")
    @CheckPermissions(PermissionEnum.DELETE_DONATION)
    public SimpleResponse<Boolean> deleteByAdmin(@RequestParam("id") Long id) {
        return new SimpleResponse<>(donationManager.delete(id, null));
    }

}
