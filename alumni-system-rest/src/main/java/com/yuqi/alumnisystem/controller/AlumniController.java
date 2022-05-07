package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.annotations.CheckPermissions;
import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.enums.PermissionEnum;
import com.yuqi.alumnisystem.manager.AlumniManager;
import com.yuqi.alumnisystem.vo.CreateOrUpdateAlumniVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优秀校友信息
 *
 * @author yuexi.guo
 * @date 2022/4/19 17:36
 */
@Validated
@RestController
@RequestMapping("/alumni")
public class AlumniController {

    @Autowired
    private AlumniManager alumniManager;

    @GetMapping("/detail")
    @ApiOperation("优秀校友详情")
    public SimpleResponse<AlumniDto> detail(@RequestParam("id") Long id){
        return new SimpleResponse<>(alumniManager.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("优秀校友列表")
    public SimpleResponse<List<AlumniDto>> list(@RequestParam(value = "userId", required = false) Long userId) {
        return new SimpleResponse<>(alumniManager.listByUserId(userId));
    }

    @PostMapping("/createOrUpdate")
    @ApiOperation("创建或修改优秀校友信息")
    @CheckPermissions(PermissionEnum.CREATE_OR_UPDATE_ALUMNI)
    public SimpleResponse<Long> createOrUpdate(@Validated @RequestBody CreateOrUpdateAlumniVo vo){
        return new SimpleResponse<>(alumniManager.createOrUpdate(vo));
    }

    @GetMapping("/delete")
    @ApiOperation("删除优秀校友信息")
    @CheckPermissions(PermissionEnum.DELETE_ALUMNI)
    public SimpleResponse<Boolean> delete(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        return new SimpleResponse<>(alumniManager.delete(id, userId));
    }

}
