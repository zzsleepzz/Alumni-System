package com.yuqi.alumnisystem.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yuexi.guo
 * @date 2022 16:51
 */
@Data
public class CreateOrUpdateActivityVo {

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
     * 标题
     */
    @NotBlank
    private String title;

    /**
     * 内容
     */
    @NotBlank
    private String content;

    /**
     * 时间
     */
    @NotNull
    private String time;

}
