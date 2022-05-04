package com.yuqi.alumnisystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuexi.guo
 * @date 2022 16:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDto {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    private Date time;

}
