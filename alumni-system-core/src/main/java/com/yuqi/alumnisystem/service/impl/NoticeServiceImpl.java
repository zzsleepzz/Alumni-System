package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Notice;
import com.yuqi.alumnisystem.service.NoticeService;
import com.yuqi.alumnisystem.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2022-04-19 19:15:40
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




