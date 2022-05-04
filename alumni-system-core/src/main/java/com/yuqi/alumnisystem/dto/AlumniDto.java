package com.yuqi.alumnisystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022 17:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumniDto {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 优秀校友名
     */
    @ApiModelProperty("优秀校友名")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 图片url
     */
    @ApiModelProperty("图片url")
    private String url;

}
