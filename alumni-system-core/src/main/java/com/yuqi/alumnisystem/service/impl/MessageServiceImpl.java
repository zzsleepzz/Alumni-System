package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Message;
import com.yuqi.alumnisystem.service.MessageService;
import com.yuqi.alumnisystem.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【message】的数据库操作Service实现
* @createDate 2022-04-19 19:15:36
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




