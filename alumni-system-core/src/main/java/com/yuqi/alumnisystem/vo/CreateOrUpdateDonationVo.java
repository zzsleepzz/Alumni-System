package com.yuqi.alumnisystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author yuexi.guo
 * @date 2022 23:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrUpdateDonationVo {

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
     * 捐款人
     */
    @NotBlank
    private String name;

    /**
     * 捐款数目
     */
    @NotBlank
    private BigDecimal value;

    /**
     * 时间
     */
    @NotNull
    private String time;

}
