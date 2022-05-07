package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.NoticeDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.NoticeManager;
import com.yuqi.alumnisystem.vo.CreateOrUpdateNoticeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告
 * @author yuexi.guo
 * @date 2022/4/19 17:37
 */
@Validated
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeManager noticeManager;

    @GetMapping("/detail")
    @ApiOperation("公告详情")
    public SimpleResponse<NoticeDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(noticeManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("公告列表")
    public SimpleResponse<List<NoticeDto>> list(@RequestParam(value = "userId", required = false) Long userId) {
        return new SimpleResponse<>(noticeManager.list(userId));
    }


    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改公告")
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateNoticeVo vo){
        return new SimpleResponse<>(noticeManager.createOrUpdate(vo));
    }

    @GetMapping("/deleteByAdmin")
    @ApiOperation("删除公告")
    @CheckPermissions(PermissionEnum.DELETE_ALL_ACTIVITY)
    public SimpleResponse<Boolean> deleteByAdmin(@RequestParam("id") Long id) {
        return new SimpleResponse<>(noticeManager.delete(id, null));
    }

}
