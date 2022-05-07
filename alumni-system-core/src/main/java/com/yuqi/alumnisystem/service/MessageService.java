package com.yuqi.alumnisystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqi.alumnisystem.dto.MessageDto;
import com.yuqi.alumnisystem.entity.Message;

import java.util.List;

/**
* @author Administrator
* @description 针对表【message】的数据库操作Service
* @createDate 2022-04-19 19:15:36
*/
public interface MessageService extends IService<Message> {

    Message getByIdAndUserId(Long id, Long userId);

    List<MessageDto> listByUserId(Long userId);

}
