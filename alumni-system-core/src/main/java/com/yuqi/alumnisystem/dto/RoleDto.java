package com.yuqi.alumnisystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022/4/21 11:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    /**
     * 主键ID
     */
    @ApiModelProperty("角色id")
    private Long id;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty("角色类型")
    private Integer type;

}
