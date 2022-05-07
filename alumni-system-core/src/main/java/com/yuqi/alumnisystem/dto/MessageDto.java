package com.yuqi.alumnisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuexi.guo
 * @date 2022 23:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 时间
     */
    private Date time;
}
