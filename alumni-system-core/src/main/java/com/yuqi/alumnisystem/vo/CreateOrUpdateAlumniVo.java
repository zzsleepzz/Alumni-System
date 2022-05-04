package com.yuqi.alumnisystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yuexi.guo
 * @date 2022 18:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrUpdateAlumniVo {

    /**
     * 主键ID
     */
    @Min(1)
    private Long id;

    /**
     * 用户ID
     */
    @NotNull
    @Min(1)
    private Long userId;

    /**
     * 优秀校友名
     */
    @NotNull
    private String name;

    /**
     * 描述
     */
    @NotNull
    private String description;

    /**
     * 图片url
     */
    @NotNull
    private String url;

}
