package com.yuqi.alumnisystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuexi.guo
 * @date 2022/4/20 11:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentUser {

    private Long id;

    private String[] permissions;

}
