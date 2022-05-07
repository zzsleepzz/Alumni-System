package com.yuqi.alumnisystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yuexi.guo
 * @date 2022 23:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrUpdateMessageVo {

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
