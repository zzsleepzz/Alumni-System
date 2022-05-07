package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.dto.MessageDto;
import com.yuqi.alumnisystem.entity.Message;
import com.yuqi.alumnisystem.mapper.MessageMapper;
import com.yuqi.alumnisystem.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【message】的数据库操作Service实现
* @createDate 2022-04-19 19:15:36
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

    @Override
    public Message getByIdAndUserId(Long id, Long userId) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>(Message.builder()
                .id(id)
                .userId(userId)
                .deleted(false)
                .build());
        return getOne(queryWrapper);
    }

    @Override
    public List<MessageDto> listByUserId(Long userId) {
        return baseMapper.list(userId);
    }
}




