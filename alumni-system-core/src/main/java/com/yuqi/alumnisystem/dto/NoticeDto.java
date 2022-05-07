package com.yuqi.alumnisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuexi.guo
 * @date 2022 22:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 时间
     */
    private Date time;

}
