package com.yuqi.alumnisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yuexi.guo
 * @date 2022 23:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonationDto {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 捐款人
     */
    private String name;

    /**
     * 捐款数目
     */
    private BigDecimal value;

    /**
     * 时间
     */
    private Date time;
}
