package com.yuqi.alumnisystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022/4/20 19:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @ApiModelProperty("学校系统ID")
    private Long schoolSystemId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private String phone;


}
