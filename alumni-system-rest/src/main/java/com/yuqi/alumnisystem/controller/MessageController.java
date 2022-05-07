package com.yuqi.alumnisystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.MessageDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.MessageManager;
import com.yuqi.alumnisystem.vo.CreateOrUpdateMessageVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 留言
 * @author yuexi.guo
 * @date 2022/4/19 17:37
 */
@Validated
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageManager messageManager;

    @GetMapping("/detail")
    @ApiOperation("留言详情")
    public SimpleResponse<MessageDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(messageManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("留言列表")
    public SimpleResponse<Page<MessageDto>> list(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
        return new SimpleResponse<>(messageManager.list(pageNo, null));
    }

    @GetMapping("/listByUserId")
    @ApiOperation("留言列表(用户个人)")
    public SimpleResponse<Page<MessageDto>> listByUserId(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam("userId") Long userId) {
        return new SimpleResponse<>(messageManager.list(pageNo, userId));
    }

    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改留言")
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateMessageVo vo){
        return new SimpleResponse<>(messageManager.createOrUpdate(vo));
    }

    @GetMapping("/delete")
    @ApiOperation("删除个人留言")
    @CheckPermissions(PermissionEnum.DELETE_OWN_MESSAGE)
    public SimpleResponse<Boolean> delete(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        return new SimpleResponse<>(messageManager.delete(id, userId));
    }

    @GetMapping("/deleteByAdmin")
    @ApiOperation("删除留言")
    @CheckPermissions(PermissionEnum.DELETE_ALL_MESSAGE)
    public SimpleResponse<Boolean> deleteByAdmin(@RequestParam("id") Long id) {
        return new SimpleResponse<>(messageManager.delete(id, null));
    }


}
