package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.NoticeDto;
import com.yuqi.alumnisystem.entity.Notice;

import java.util.List;

/**
* @author Administrator
* @description 针对表【notice】的数据库操作Service
* @createDate 2022-04-19 19:15:40
*/
public interface NoticeService extends IService<Notice> {

    Notice getByIdAndUserId(Long id, Long userId);

    List<NoticeDto> listByUserId(Long userId);
}
