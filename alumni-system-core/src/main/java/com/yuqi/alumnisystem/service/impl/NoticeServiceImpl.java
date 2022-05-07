package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.dto.NoticeDto;
import com.yuqi.alumnisystem.entity.Notice;
import com.yuqi.alumnisystem.mapper.NoticeMapper;
import com.yuqi.alumnisystem.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2022-04-19 19:15:40
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

    @Override
    public Notice getByIdAndUserId(Long id, Long userId) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper(Notice.builder()
                .id(id)
                .userId(userId)
                .deleted(false)
                .build());
        return getOne(queryWrapper);
    }

    @Override
    public List<NoticeDto> listByUserId(Long userId) {
        return baseMapper.list(userId);
    }

}




