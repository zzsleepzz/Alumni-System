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

    @Min(1)
    private Long id;

    @NotNull
    @Min(1)
    private Long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private String date;

}
