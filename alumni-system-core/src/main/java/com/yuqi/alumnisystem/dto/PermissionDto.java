package com.yuqi.alumnisystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022/4/24 20:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionDto {
    /**
     * 权限点
     */
    @ApiModelProperty("权限点")
    private Integer permissionValue;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;
}
